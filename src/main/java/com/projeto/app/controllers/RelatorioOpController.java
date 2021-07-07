package com.projeto.app.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;
import com.projeto.app.configs.tools.UserPDFExporter;
import com.projeto.app.models.RelatorioBruto;
import com.projeto.app.models.RelatorioOperacao;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.repositories.RelatorioBrutoRepository;
import com.projeto.app.repositories.RelatorioOperacaoRepository;
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

@Api(description = "Relatórios para cada Operação",tags = { "Relatórios de Operações" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/relatorio/op")
public class RelatorioOpController {

    @Autowired
    private Calcular calc;

    @Autowired
    private RelatorioOperacaoRepository relatorioOpR;

    @Autowired
    private RelatorioBrutoRepository relatorioR;

    @Autowired
    private OperacaoRepository operacaoR;

    @GetMapping("/{mes}")
    @ApiOperation(value = "Buscar relatórios apartir do mês!")
    public ResponseEntity<?> FindRelatorioOpByMes(HttpServletResponse response, @PathVariable("mes") Long mes)
            throws DocumentException, IOException {
        List<RelatorioOperacao> lista = relatorioOpR.findAllByMes(mes);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de Relatórios por operação esta vazia");
        }
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RELATÓRIO_MÊS_" + mes + ".pdf";
        response.setContentType("application/pdf");
        response.setHeader(headerKey, headerValue);
        UserPDFExporter PDF = new UserPDFExporter(lista);
        PDF.export(response);
        return ResponseEntity.status(HttpStatus.FOUND).body(lista);
    }

    @DeleteMapping("/{mes}")
    @ApiOperation(value = "Deletar todos relatórios operação pelo mês")
    public ResponseEntity<?> deletarRelatorioOperacao(@PathVariable("mes") Long mes) {

        List<RelatorioOperacao> findAllByMes = relatorioOpR.findAllByMes(mes);

        if (findAllByMes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            for (RelatorioOperacao relatorioOperacao : findAllByMes) {
                relatorioOpR.deleteById(relatorioOperacao.getId());
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        }

    }

    @PostMapping("/{mes}")
    @ApiOperation(value = "Gerar relatórios automático de todas as operações pelo mês!")
    public ResponseEntity<?> CreatebyOperacao(@PathVariable("mes") Long mes) {

        if (mes <= 12 && mes != 0) {
            RelatorioBruto relatorioBruto = relatorioR.findByMes(mes);
            if (relatorioBruto != null) {
                List<RelatorioOperacao> ListCreateOperacao = calc.gerarByOperacao(relatorioBruto, relatorioOpR,
                        operacaoR, mes);
                // UserPDFExporter exporter = new UserPDFExporter(ListCreateOperacao);
                // email.enviarEmail("eqysselproj@gmail.com", exporter);
                return ResponseEntity.ok().body(ListCreateOperacao);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe relatório para este mês");
        }
        return ResponseEntity.badRequest().body("Não existe este mês");
    }
    
}