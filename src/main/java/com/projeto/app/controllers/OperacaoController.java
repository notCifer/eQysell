package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.dto.OperacaoDTO;
import com.projeto.app.models.form.OperacaoFORM;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.services.Calcular;
import com.projeto.app.services.EnumService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.ApiOperation;

@Api(description = "Controle de operações", tags = { "Operação" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoR;

    @Autowired
    private Calcular calc;

    @Autowired
    private EnumService enumS;

    
    @GetMapping
    @ApiOperation(value = "Lista todas Operações")
    public ResponseEntity<?> FindAll() {
        List<Operacao> findList = operacaoR.findAll();
        if (findList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        OperacaoDTO dto = new OperacaoDTO();
        return ResponseEntity.ok().body(dto.toDTO(findList));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca de Operação por Id")
    public ResponseEntity<?> findOneOperacao(@PathVariable long id) {
        try {
            Operacao o = operacaoR.getById(id);
            OperacaoDTO dto = new OperacaoDTO();
            return ResponseEntity.ok().body(dto.toDTO(o));
        } catch (EntityNotFoundException x) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operação não foi encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Operacao> optional = operacaoR.findById(id);
        if (optional.isPresent()) {
            operacaoR.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operação não encontrada");
    }
    
    @PutMapping
    @ApiOperation(value = "Alterar Operacao")
    public ResponseEntity<?> alterarOperacao(@RequestBody @Valid OperacaoFORM FORM){
        Optional<Operacao> findByNome = operacaoR.findByNome(FORM.getNome());
        if (findByNome.isPresent()) {
            Operacao operacao = findByNome.get();
            operacao.setCdr(FORM.toAlter(operacaoR, enumS, calc, operacao,FORM.getAbl()));
            operacao.setCnpj(FORM.getCnpj());
            operacao.setRazaosocial(FORM.getRazaosocial());
            operacao.setResponse(FORM.getResponse());
            operacaoR.save(operacao);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de Operações")
    public ResponseEntity<?> Add(@RequestBody @Valid OperacaoFORM FORM, UriComponentsBuilder uri) {
        try {
            Operacao o = FORM.toFORM(operacaoR, enumS, calc);
            URI u = uri.path("/operacao/{id}").buildAndExpand(o.getId()).toUri();
            return ResponseEntity.created(u).body(new OperacaoDTO().toDTO(o));
        } catch (DataIntegrityViolationException SQL) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados já utilizados");
        }
    }

}
