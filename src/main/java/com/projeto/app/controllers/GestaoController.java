package com.projeto.app.controllers;

import java.util.List;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.dto.GestaoDTO;
import com.projeto.app.models.form.GestaoFORM;
import com.projeto.app.repositories.GestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestao")
public class GestaoController {

    @Autowired
    public GestaoRepository gestaoR;

    @GetMapping
    public List<GestaoDTO> FindAll() {
        GestaoDTO DTO = new GestaoDTO();
        List<Gestao> gList = gestaoR.findAll();
        return DTO.toDTO(gList);
    }

    @GetMapping("/tipo/{id}")
    public ResponseEntity<?> Total(@PathVariable Long id){
        List<Gestao> gList = gestaoR.findAllBytipo(id);
        Double total = 0.0;
        for (Gestao gestao : gList) {
            total += gestao.getValor();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("TIPO : " + id + "\nTOTAL : " + total);
    }

    @PostMapping
    public GestaoDTO Add(@RequestBody GestaoFORM FORM) {
        GestaoDTO DTO = new GestaoDTO(); 
        Gestao gestao = FORM.toFORM(gestaoR);
        return DTO.toDTO(gestao);
    }
 
}