package com.projeto.app.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.projeto.app.models.Gestao;
import com.projeto.app.models.dto.GestaoDTO;
import com.projeto.app.models.form.GestaoFORM;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.services.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "Controle de despesas",tags = { "Despesas" })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/despesa")
public class DespesaController {


    @Autowired
    public GestaoRepository gestaoR;

    @Autowired
    private EnumService enumS;

    // _____Métodos_____//

    @GetMapping
    @ApiOperation(value = "Lista todas as despesas")
    public List<GestaoDTO> FindAll() {
        GestaoDTO DTO = new GestaoDTO();
        List<Gestao> gList = gestaoR.findAll();
        return DTO.toDTO(gList);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar despesa pelo id")
    public ResponseEntity<?> deletarDepesa(@PathVariable("id") Long id) {
        Optional<Gestao> findById = gestaoR.findById(id);
        if (findById.isPresent()) {
            gestaoR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    @ApiOperation(value = "Deletar despesa pela descrição")
    public ResponseEntity<?> alterarDepesa(@RequestBody @Valid GestaoFORM FORM) {
        Optional<Gestao> findByDescricao = gestaoR.findByDescricao(FORM.getDescricao());
        if (findByDescricao.isPresent()) {
            Gestao gestao = findByDescricao.get();
            gestao.setDataCreate(LocalDate.now());
            gestao.setTipo(enumS.findTipo(FORM.getidTipo()));
            gestao.setValor(FORM.getValor());
            gestaoR.save(gestao);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar uma despesa")
    public GestaoDTO Add(@RequestBody @Valid GestaoFORM FORM) {
        GestaoDTO DTO = new GestaoDTO();
        Gestao gestao = FORM.toFORM(gestaoR, enumS);
        return DTO.toDTO(gestao);
    }

    

  

}