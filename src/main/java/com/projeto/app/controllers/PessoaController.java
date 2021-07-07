package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Controle de pessoas", tags = { "Pessoa" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaR;

    @Autowired
    private UsuarioRepository usuarioR;

    @GetMapping
    @ApiOperation(value = "Lista todas Pessoas")
    public ResponseEntity<?> FindAll() {
        PessoaDTO DTO = new PessoaDTO();
        List<Pessoa> pessoa = pessoaR.findAll();
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(pessoa));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca pessoa pelo ID")
    public ResponseEntity<?> FindByID(@PathVariable Long id) {
        PessoaDTO DTO = new PessoaDTO();
        try {
            Pessoa pessoa = pessoaR.getById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(pessoa));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }

    }

    @PutMapping
    @ApiOperation(value = "Alterar pessoa pelo cpf")
    public ResponseEntity<?> alterarOperacao(@RequestBody @Valid PessoaFORM FORM){
        Optional<Pessoa> findByCpf = pessoaR.findByCpf(FORM.getCpf());
        if (findByCpf.isPresent()) {
            Pessoa pessoa = findByCpf.get();
            pessoa.setCep(FORM.getCep());
            pessoa.setComplemento(FORM.getComplemento());
            pessoa.setCpf(FORM.getCpf());
            pessoa.setEndereco(FORM.getEndereco());
            pessoa.setFoto(FORM.getFoto());
            pessoa.setNumero(FORM.getNumero());
            pessoa.setTelefone(FORM.getTelefone());
            pessoa.setUsuario(usuarioR.getById(FORM.getId_usuario()));
            pessoaR.save(pessoa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } 

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta pessoa pelo ID")
    public ResponseEntity<?> DeleteByID(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaR.findById(id);

        if (pessoa.isPresent()) {
            pessoaR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa de ID" + id + "\n Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
    }

    @PostMapping
    @ApiOperation(value = "Cadastra uma pessoa")
    public ResponseEntity<?> Add(@RequestBody @Valid PessoaFORM FORM, UriComponentsBuilder uriBuilder) {
        PessoaDTO DTO = new PessoaDTO();
        try {
            Pessoa pessoa = FORM.toFORM(pessoaR, usuarioR);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
            return ResponseEntity.created(uri).body(DTO.toDTO(pessoa));
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }

    }

}