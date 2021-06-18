package com.projeto.app.models.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.projeto.app.models.Locatario;
import com.projeto.app.repositories.LocatarioRepository;

public class LocatarioFORM {
    
    @NotNull
    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @Size(max = 11)
    private Long cpf;
    @NotBlank
    @NotNull
    private String endereco;
    @NotBlank
    @NotNull
    private String email;
    @NotNull
    @Size(max = 12)
    private Long telefone;

    /* ___________________________GETTERS and SETTERS___________________________ */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    /* ___________________________toFORM___________________________ */

    public Locatario toFORM(LocatarioRepository LocatarioR) {
        Locatario locatario = new Locatario(id,nome, cpf, endereco, email, telefone);
        LocatarioR.save(locatario);
        return locatario;
    }

}