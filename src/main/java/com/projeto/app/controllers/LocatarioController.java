package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import com.projeto.app.models.Locatario;
import com.projeto.app.models.dto.LocatarioDTO;
import com.projeto.app.models.form.LocatarioFORM;
import com.projeto.app.repositories.LocatarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Api(tags = { "Locatário" })
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioRepository LocatarioR;

            //_____Métodos_____//

    /* __________LISTAR LOCÁTARIOS__________ */
    @ApiOperation(value="Listagem Completa de Locatários")
    @GetMapping
    public ResponseEntity<?> FindAll() {
        List<Locatario> locatarios = LocatarioR.findAll();
        LocatarioDTO DTO = new LocatarioDTO();
        if (locatarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(locatarios));

    }

    @GetMapping("/{id}")
    @ApiOperation(value="Busca por ID")
    public ResponseEntity<?> FindByID(@PathVariable Long id) {

        try {
            Locatario locatario = LocatarioR.getById(id);
            LocatarioDTO DTO = new LocatarioDTO();
            return ResponseEntity.status(HttpStatus.OK).body(DTO.toDTO(locatario));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locatário não foi encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete")
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        Optional<Locatario> locatario = LocatarioR.findById(id);
        if (locatario.isPresent()) {
            LocatarioR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Locatario de ID" + id + "\n Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locatario não encontrado");
    }

    /* __________POSTAR LOCATARIOS__________ */
    @PostMapping
    @ApiOperation(value="Postagem")
    public ResponseEntity<LocatarioDTO> Add(@RequestBody @Valid LocatarioFORM form, UriComponentsBuilder UriBuilder) {
        Locatario locatario = form.toFORM(LocatarioR);
        LocatarioDTO DTO = new LocatarioDTO();
        URI uri = UriBuilder.path("/{id}").buildAndExpand(locatario.getId()).toUri();
        return ResponseEntity.created(uri).body(DTO.toDTO(locatario));
    }

}
