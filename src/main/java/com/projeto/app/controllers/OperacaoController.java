package com.projeto.app.controllers;

import com.projeto.app.models.Operacao;
import com.projeto.app.models.dto.OperacaoDTO;
import com.projeto.app.models.form.OperacaoFORM;
import com.projeto.app.repositories.OperacaoRepository;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
//import io.swagger.annotations.ApiOperation;

//@Api(description = "Busque e Cadastre sua Operação", tags = { "Operação" })
//@CrossOrigin(origins="*")
@RestController(value = "/operacao")
public class OperacaoController {

    @Autowired
    OperacaoRepository OR;

    @GetMapping
    //@ApiOperation(value="Método de Listagem Completa")
    public ResponseEntity<?> FindAll() {

        List<Operacao> ops = OR.findAll();
        OperacaoDTO DTO = new OperacaoDTO();
        if (ops.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista está vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(ops));

    }

    @GetMapping("/{id}")
    //@ApiOperation(value="Busca de Operação por Id")
    public ResponseEntity<?> findOneOperacao(@PathVariable long id){
        try {
            Operacao o = OR.getById(id);
            OperacaoDTO dto = new OperacaoDTO();
            return ResponseEntity.ok().body(dto.toDTO(o));
        }
        catch (EntityNotFoundException x){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }

    @PostMapping
    //@ApiOperation(value="Cadastro de Operações")
    public ResponseEntity<?> CadastreOperacao(@RequestBody @Valid OperacaoFORM OF, UriComponentsBuilder uri)
    {
        try
        {
            Operacao o = OF.toForm(OR);
            URI u = uri.path("/operacao/{id}").buildAndExpand(o.getId()).toUri();
            return ResponseEntity.created(u).body(new OperacaoDTO().toDTO(o));
        }
        catch (DataIntegrityViolationException SQL)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados já utilizados");
        }
    }

    @DeleteMapping("/{id}")
    //@ApiOperation(value="Delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Operacao> optional = OR.findById(id);
        if (optional.isPresent()) {
            OR.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
