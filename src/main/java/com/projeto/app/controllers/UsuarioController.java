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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Api(tags = { "Usuário" })
@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioR;

    //_____Métodos_____//

    @GetMapping
    @ApiOperation(value="Método de Listagem Completa de Usuários")
    public ResponseEntity<?> FindAll() {
        List<Usuario> usuarios = usuarioR.findAll();
        UsuarioDTO DTO = new UsuarioDTO();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(DTO.toDTO(usuarios));
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Busca por ID")
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
    @ApiOperation(value="Delete")
    public ResponseEntity<?> DeleteByID(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioR.findById(id);
        if (usuario.isPresent()) {
            usuarioR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario de ID" + id + "\n Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");

    }

    @PostMapping
    @ApiOperation(value="Postagem")
    public ResponseEntity<UsuarioDTO> Add(@RequestBody @Valid UsuarioFORM FORM, UriComponentsBuilder uriBuilder) {
        Usuario usuario = FORM.toFORM(usuarioR);
        UsuarioDTO DTO = new UsuarioDTO();
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(DTO.toDTO(usuario));
    }

}