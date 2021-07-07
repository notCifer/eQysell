package com.projeto.app.controllers;

import java.net.URI;
import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/user")
@RestController
@Api(description = "(PERMITIDO) Controle de usuários", tags = { "Login" })
public class AddLoginController {

    @Autowired
    private UsuarioRepository UsuarioR;

    @ApiOperation(value = "Buscar todos os emails dos usuários cadastrados.")
    @GetMapping
    public ResponseEntity<?> FindAllUsuarios() {

        try {
            List<Usuario> logins = UsuarioR.findAll();
            UsuarioDTO DTO = new UsuarioDTO();
            return ResponseEntity.ok().body(DTO.toDTO(logins));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista está vazia");
        }
    }

    @ApiOperation(value = "Buscar um email de um usuário cadastrado pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> FindOneUsuario(@PathVariable Long id) {
        Usuario login = UsuarioR.getById(id);
        UsuarioDTO DTO = new UsuarioDTO();
        if (login != null) {
            return ResponseEntity.ok().body(DTO.toDTO(login));
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Deletar um usuário cadastrado pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoveUsuario(@PathVariable Long id) {

        Usuario usuario = UsuarioR.getById(id);
        if (usuario != null) {
            UsuarioR.delete(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario de ID: " + id + ", foi deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario de ID: " + id + ", não existe." + "\n Por favor insira um usuário valido!");

    }

    @ApiOperation(value = "Alterar um usario pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<?> AlterPessoa(@PathVariable Long id, @Valid UsuarioFORM FORM) {
        try {
            Usuario usuario = UsuarioR.getById(id);
            if (usuario!= null) {
                usuario.setEmail(FORM.getEmail());
                usuario.setSenha(FORM.getSenha());
                UsuarioDTO DTO = new UsuarioDTO();
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(DTO.toDTO(usuario)); 
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @ApiOperation(value = "Criar um usuário.")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid UsuarioFORM FORM, UriComponentsBuilder uriBuilder) {
        Usuario login = FORM.toFORM(UsuarioR);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(login.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO().toDTO(login));
    }

}