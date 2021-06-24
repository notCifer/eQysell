package com.projeto.app.controllers;

import java.util.List;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.Relatorio;
import com.projeto.app.models.dto.GestaoDTO;
import com.projeto.app.models.form.GestaoFORM;
import com.projeto.app.models.gestao.GerarRelatorio;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.repositories.RelatorioRepository;
import com.projeto.app.services.Calcular;
import org.springframework.beans.factory.annotation.Autowired;
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
    private GerarRelatorio gRelatorio;

    @Autowired
    private RelatorioRepository relatorioR;


    @GetMapping
    public List<GestaoDTO> FindAll() {
        GestaoDTO DTO = new GestaoDTO();
        List<Gestao> gList = gestaoR.findAll();
        return DTO.toDTO(gList);
    }

    @GetMapping("/{mes}")
    public ResponseEntity<?> Total(@PathVariable("mes") Long mes){
        Relatorio relatorio = new Relatorio();
        for (int tipo = 0; tipo < TipoEnum.values().length; tipo++) {
            relatorio = gRelatorio.inserirDados(gestaoR, calc, tipo, mes,relatorio);
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
 
}