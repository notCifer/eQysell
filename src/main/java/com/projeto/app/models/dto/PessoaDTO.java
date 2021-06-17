package com.projeto.app.models.dto;

import java.time.LocalDateTime;

import com.projeto.app.models.Pessoa;
import com.projeto.app.models.Usuario;

public class PessoaDTO {

    private String nome;
    private Long cpf;
    private Long cep;
    private String endereco;
    private String complemento;
    private Long numero;
    private Long telefone;
    private LocalDateTime dt_nascimento;
    private Byte[] foto;
    private Usuario usuario;

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

    public PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO DTO = new PessoaDTO();
        DTO.setNome(pessoa.getNome());
        DTO.setCpf(pessoa.getCpf());
        DTO.setCep(pessoa.getCep());
        DTO.setEndereco(pessoa.getEndereco());
        DTO.setComplemento(pessoa.getComplemento());
        DTO.setNumero(pessoa.getNumero());
        DTO.setTelefone(pessoa.getTelefone());
        DTO.setDt_nascimento(pessoa.getDt_nascimento());
        DTO.setUsuario(pessoa.getUsuario());
        DTO.setDt_nascimento(pessoa.getDt_nascimento());
        return DTO;
    }

}