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

@Api(description = "Busque e Cadastre sua Operação", tags = { "Operação" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoRepository OR;

    @Autowired
    private Calcular calc;

    @Autowired
    private EnumService enumS;

    @ApiOperation(value = "Método de Listagem Completa")
    @GetMapping
    public ResponseEntity<?> FindAll() {
        List<Operacao> findList = OR.findAll();
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
            Operacao o = OR.getById(id);
            OperacaoDTO dto = new OperacaoDTO();
            return ResponseEntity.ok().body(dto.toDTO(o));
        } catch (EntityNotFoundException x) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operação não foi encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Operacao> optional = OR.findById(id);
        if (optional.isPresent()) {
            OR.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operação não encontrada");
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de Operações")
    public ResponseEntity<?> Add(@RequestBody @Valid OperacaoFORM OF, UriComponentsBuilder uri) {
        try {
            Operacao o = OF.toFORM(OR, enumS, calc);
            URI u = uri.path("/operacao/{id}").buildAndExpand(o.getId()).toUri();
            return ResponseEntity.created(u).body(new OperacaoDTO().toDTO(o));
        } catch (DataIntegrityViolationException SQL) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados já utilizados");
        }
    }

}
