package com.projeto.app.controllers;

import java.util.List;
import com.projeto.app.configs.services.EmailService;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.RelatorioBruto;
import com.projeto.app.models.RelatorioOperacao;
import com.projeto.app.models.dto.GestaoDTO;
import com.projeto.app.models.form.GestaoFORM;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.repositories.RelatorioBrutoRepository;
import com.projeto.app.repositories.RelatorioOperacaoRepository;
import com.projeto.app.services.Calcular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestao")
public class GestaoController {

    @Autowired
    public GestaoRepository gestaoR;

    @Autowired
    private Calcular calc;

    @Autowired
    private RelatorioBrutoRepository relatorioR;

    @Autowired
    private RelatorioOperacaoRepository relatorioOpR;

    @Autowired
    private OperacaoRepository operacaoR;

    @Autowired
    private EmailService eController;

    @GetMapping
    public List<GestaoDTO> FindAll() {
        GestaoDTO DTO = new GestaoDTO();
        List<Gestao> gList = gestaoR.findAll();
        return DTO.toDTO(gList);
    }

    @GetMapping("/{mes}")
    public ResponseEntity<?> Total(@PathVariable("mes") Long mes) {
        RelatorioBruto relatorio = new RelatorioBruto();
        for (int tipo = 0; tipo < TipoEnum.values().length; tipo++) {
            relatorio = calc.gerarBruto(gestaoR, tipo, mes, relatorio);
        }
        relatorioR.save(relatorio);
        return ResponseEntity.ok().body(relatorio);
    }

    @PostMapping
    public GestaoDTO Add(@RequestBody GestaoFORM FORM) {
        GestaoDTO DTO = new GestaoDTO();
        Gestao gestao = FORM.toFORM(gestaoR);
        return DTO.toDTO(gestao);
    }

    @GetMapping("/op/{mes}")
    public ResponseEntity<?> FindRelatorioOpByMes(@PathVariable("mes") Long mes) {
        List<RelatorioOperacao> listaRelatorioOperacao = relatorioOpR.findAllByMes(mes);
        if (listaRelatorioOperacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de Relatórios por operação esta vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listaRelatorioOperacao);
    }

    @GetMapping("/op/create/{mes}")
    public ResponseEntity<?> CreatebyOperacao(@PathVariable("mes") Long mes) {

        if (mes <= 12 && mes != 0) {
            RelatorioBruto relatorioBruto = relatorioR.findByMes(mes);
            if (relatorioBruto != null) {
                List<RelatorioOperacao> ListCreateOperacao = calc.gerarByOperacao(relatorioBruto, relatorioOpR,
                        operacaoR, mes, eController);
                return ResponseEntity.ok().body(ListCreateOperacao);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe relatório para este mês");
        }
        return ResponseEntity.badRequest().body("Não existe este mês");
    }

}