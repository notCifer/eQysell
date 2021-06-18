package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.google.common.base.Optional;
import com.projeto.app.models.Locatario;
import com.projeto.app.models.Usuario;
import com.projeto.app.models.dto.LocatarioDTO;
import com.projeto.app.models.form.LocatarioFORM;
import com.projeto.app.repositories.LocatarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value = "/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioRepository LocatarioR;

     /* __________LISTAR LOCÁTARIOS__________ */
    @GetMapping
    public ResponseEntity<?> FindAll(){
        List<Locatario> locatarios = LocatarioR.findAll();
        LocatarioDTO DTO = new LocatarioDTO();
        if(locatarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(locatarios));

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> FindByID(@PathVariable Long id ) {
            try {
                Locatario locatario = LocatarioR.getById(id);
                LocatarioDTO DTO = new LocatarioDTO();
                return ResponseEntity.status(HttpStatus.OK).body(DTO.toDTO(locatario));  
                }
                catch (EntityNotFoundException e) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locatário não foi encontrado");
    }

     /* __________POSTAR LOCATARIOS__________ */
    @PostMapping
    public ResponseEntity <LocatarioDTO> cadastrar(@RequestBody @Valid LocatarioFORM form, UriComponentsBuilder uri){
        Locatario locatario = form.toFORM(LocatarioR);
        LocatarioDTO DTO = new LocatarioDTO();
        URI uri = UriBuilder.path("/{id}").buildAndExpand(locatario.getId()).toUri();
        return ResponseEntity.created(uri).body(DTO.toDTO(locatario));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        Usuario usuario = LocatarioR.getById(id);
        LocatarioR.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Locatario de ID" + id + "\n Deletado com sucesso!");
    }

    }
    


    


