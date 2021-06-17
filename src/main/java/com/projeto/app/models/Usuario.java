package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
<<<<<<< HEAD
=======
    private String senha;
>>>>>>> 4febf4be51d7ccfd885e473c5024f8108fa11266

    public Usuario() {
    }

<<<<<<< HEAD
    private String senha;
=======
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
>>>>>>> 4febf4be51d7ccfd885e473c5024f8108fa11266

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public String getEmail() {
        return email;
    }

>>>>>>> 4febf4be51d7ccfd885e473c5024f8108fa11266
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
=======
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
>>>>>>> 4febf4be51d7ccfd885e473c5024f8108fa11266

}