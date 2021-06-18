package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import com.projeto.app.models.Pessoa;
import com.projeto.app.models.dto.PessoaDTO;
import com.projeto.app.models.form.PessoaFORM;
import com.projeto.app.repositories.PessoaRepository;
import com.projeto.app.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaR;

    @Autowired
    private UsuarioRepository usuarioR;

    @GetMapping
    public ResponseEntity<?> FindAll() {
        PessoaDTO DTO = new PessoaDTO();
        List<Pessoa> pessoa = pessoaR.findAll();
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista está vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> FindByID(@PathVariable Long id) {
        PessoaDTO DTO = new PessoaDTO();
        try {
            Pessoa pessoa = pessoaR.getById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(pessoa));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }

    }

    @DeleteMapping
    public ResponseEntity<?> DeleteByID(@PathVariable Long id) {
        Pessoa pessoa = pessoaR.getById(id);
        try {
            pessoaR.delete(pessoa);
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa de ID" + id + "\n Deletado com sucesso!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> Add(@RequestBody @Valid PessoaFORM FORM, UriComponentsBuilder uriBuilder) {
        PessoaDTO DTO = new PessoaDTO();
        try {
            Pessoa pessoa = FORM.toFORM(pessoaR,usuarioR);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
            return ResponseEntity.created(uri).body(DTO.toDTO(pessoa));
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }

    }

}