package com.projeto.app.models.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.projeto.app.models.Usuario;
import com.projeto.app.repositories.UsuarioRepository;

public class UsuarioFORM {

    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 5)
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toFORM(UsuarioRepository usuarioR) {
        Usuario usuario = new Usuario(email, senha);
        usuarioR.save(usuario);
        return usuario;
    }

}