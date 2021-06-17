package com.projeto.app.models;

import java.time.LocalDateTime;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

public class Pessoa {

    private String nome;
    private Long cpf;
    private Long cep;
    private String endereco;
    private String complemento;
    private Long numero;
    private Long telefone;
    private LocalDateTime dt_nascimento;
    @Lob
    private Byte[] foto;

    @OneToOne
    private Usuario usuario;

    public Pessoa() {
    }

    public Pessoa(String nome, Long cpf, Long cep, String endereco, String complemento, Long numero, Long telefone,
            LocalDateTime dt_nascimento, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.telefone = telefone;
        this.dt_nascimento = dt_nascimento;
        this.usuario = usuario;
    }

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

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDateTime dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}