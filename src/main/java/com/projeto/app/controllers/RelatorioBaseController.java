package com.projeto.app.controllers;

import com.projeto.app.models.RelatorioBruto;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.repositories.RelatorioBrutoRepository;
import com.projeto.app.services.Calcular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Relatórios para base de calculo",tags = { "Relatório Base" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/relatorio/base")
public class RelatorioBaseController {

    @Autowired
    private RelatorioBrutoRepository relatorioR;

    @Autowired
    private Calcular calc;

    @Autowired
    public GestaoRepository gestaoR;

    @GetMapping("/{mes}")
    @ApiOperation(value = "Buscar relatório base apartir do mês!")
    public ResponseEntity<?> FindRelatorioBaseByMes(@PathVariable("mes") Long mes) {
        RelatorioBruto relatorio = relatorioR.findByMes(mes);
        if (relatorio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de Relatórios por operação esta vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(relatorio);
    }

    @DeleteMapping("/{mes}")
    @ApiOperation(value = "Deletar relatório base pelo mês")
    public ResponseEntity<?> deletarRelatorioBase(@PathVariable("mes") Long mes) {
        RelatorioBruto findByMes = relatorioR.findByMes(mes);
        if (findByMes != null) {
            relatorioR.deleteById(findByMes.getId());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/{mes}")
    @ApiOperation(value = "Gerar Relatório base pelo mês")
    public ResponseEntity<?> Total(@PathVariable("mes") Long mes) {
        RelatorioBruto findByMes = relatorioR.findByMes(mes);
        if (findByMes == null) {
            RelatorioBruto relatorio = new RelatorioBruto();
            Double totalSoma = 0.0;
            for (int tipo = 0; tipo < TipoEnum.values().length; tipo++) {
                totalSoma += calc.gerarBruto(gestaoR, tipo, mes, relatorio);
            }
            relatorio.setTotal(totalSoma);
            relatorioR.save(relatorio);
            return ResponseEntity.ok().body(relatorio);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}