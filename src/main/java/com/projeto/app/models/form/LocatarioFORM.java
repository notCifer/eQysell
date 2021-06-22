package com.projeto.app.models.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.projeto.app.models.Locatario;
import com.projeto.app.repositories.LocatarioRepository;

public class LocatarioFORM {
    
    @NotBlank
    private String nome;
    @NotNull
    private Long cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @NotNull
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
        Locatario locatario = new Locatario(nome, cpf, endereco, email, telefone);
        LocatarioR.save(locatario);
        return locatario;
    }

}