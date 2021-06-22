package com.projeto.app.controllers;

import java.util.List;
import com.projeto.app.models.form.FinanceiroFORM;
import com.projeto.app.models.gestao.Financeiro;
import com.projeto.app.repositories.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroRepository financeiroR;

    @GetMapping
    public ResponseEntity<?> FindAll() {
        List<Financeiro> financeiros = financeiroR.findAll();
        // FinanceiroDTO DTO = new FinanceiroDTO();
        return ResponseEntity.status(HttpStatus.FOUND).body(financeiros);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> FindByID(@PathVariable Long id) {

    //     try {
    //         Financeiro financeiro = financeiroR.getById(id);
    //         FinanceiroDTO DTO = new FinanceiroDTO();
    //         return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(financeiro));
    //     } catch (EntityNotFoundException e) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Financeiro não encontrado");
    //     }

    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> DeleteByID(@PathVariable Long id){

    //     Optional<Financeiro> financeiro = financeiroR.findById(id);
    //     if (financeiro.isPresent()) {
    //         financeiroR.deleteById(id);
    //         return ResponseEntity.status(HttpStatus.OK).body("Financeiro de ID" + id + "\n Deletado com sucesso!");
    //     }
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Financeiro não encontrado");

    // }

    // public ResponseEntity<?> Add(@RequestBody @Valid FinanceiroFORM FORM, UriComponentsBuilder uriBuilder){
    //     Financeiro financeiro = FORM.toFORM(financeiroR);
    //     FinanceiroDTO DTO = new FinanceiroDTO();
    //     URI uri = uriBuilder.path("/{id}").buildAndExpand(financeiro.getId()).toUri();
    //     return ResponseEntity.created(uri).body(DTO.toDTO(financeiro));
    // }


    @PostMapping
    public ResponseEntity<?> Add(@RequestBody FinanceiroFORM FORM){
        Double resultado = FORM.mostrar();
        return ResponseEntity.ok().body("Resultado da soma: " + resultado);
    }

}