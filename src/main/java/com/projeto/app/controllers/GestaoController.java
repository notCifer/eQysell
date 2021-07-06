package com.projeto.app.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.DocumentException;
import com.projeto.app.configs.tools.UserPDFExporter;
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
import com.projeto.app.services.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = { "Gestão" })
@CrossOrigin(origins = "*")
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

    // @Autowired
    // private EmailService email;

    @Autowired
    private EnumService enumS;

    // _____Métodos_____//

    @GetMapping("/despesa")
    @ApiOperation(value = "Lista todas as despesas")
    public List<GestaoDTO> FindAll() {
        GestaoDTO DTO = new GestaoDTO();
        List<Gestao> gList = gestaoR.findAll();
        return DTO.toDTO(gList);
    }

    @GetMapping("/relatorio/base/{mes}")
    @ApiOperation(value = "Buscar relatório base apartir do mês!")
    public ResponseEntity<?> FindRelatorioBaseByMes(@PathVariable("mes") Long mes) {
        RelatorioBruto relatorio = relatorioR.findByMes(mes);
        if (relatorio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de Relatórios por operação esta vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(relatorio);
    }

    @GetMapping("/relatorio/op/{mes}")
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

    @PostMapping("/despesa")
    @ApiOperation(value = "Cadastrar uma despesa")
    public GestaoDTO Add(@RequestBody GestaoFORM FORM) {
        GestaoDTO DTO = new GestaoDTO();
        Gestao gestao = FORM.toFORM(gestaoR, enumS);
        return DTO.toDTO(gestao);
    }

    @PostMapping("/relatorio/base/{mes}")
    @ApiOperation(value = "Gerar Relatório base pelo mês")
    public ResponseEntity<?> Total(@PathVariable("mes") Long mes) {
        RelatorioBruto relatorio = new RelatorioBruto();
        Double totalSoma = 0.0;
        for (int tipo = 0; tipo < TipoEnum.values().length; tipo++) {
            totalSoma += calc.gerarBruto(gestaoR, tipo, mes, relatorio);
        }
        relatorio.setTotal(totalSoma);
        relatorioR.save(relatorio);
        return ResponseEntity.ok().body(relatorio);
    }

    @PostMapping("/relatorio/op/{mes}")
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