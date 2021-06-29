package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import com.projeto.app.models.Usuario;
import com.projeto.app.models.dto.UsuarioDTO;
import com.projeto.app.models.form.UsuarioFORM;
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
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioR;

    @GetMapping
    public ResponseEntity<?> FindAll() {
        List<Usuario> usuarios = usuarioR.findAll();
        UsuarioDTO DTO = new UsuarioDTO();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(usuarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> FindByID(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioR.getById(id);
            UsuarioDTO DTO = new UsuarioDTO();
            return ResponseEntity.status(HttpStatus.OK).body(DTO.toDTO(usuario));

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteByID(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioR.findById(id);
        if (usuario.isPresent()) {
            usuarioR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario de ID" + id + "\n Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");

    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> Add(@RequestBody @Valid UsuarioFORM FORM, UriComponentsBuilder uriBuilder) {
        Usuario usuario = FORM.toFORM(usuarioR);
        UsuarioDTO DTO = new UsuarioDTO();
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(DTO.toDTO(usuario));
    }

}