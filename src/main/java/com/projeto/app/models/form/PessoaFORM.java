package com.projeto.app.models.form;

import java.io.IOException;
import java.time.LocalDate;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.projeto.app.models.Pessoa;
import com.projeto.app.models.Usuario;
import com.projeto.app.repositories.PessoaRepository;
import com.projeto.app.repositories.UsuarioRepository;

import org.springframework.web.multipart.MultipartFile;

public class PessoaFORM {

    @NotBlank
    private String nome;
    @NotNull
    private Long cpf;
    @NotNull
    private Long cep;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotNull
    private Long numero;
    @NotNull
    private Long telefone;
    @NotNull
    private LocalDate dt_nascimento;
    private Byte[] foto;
    private Long id_usuario;
    
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

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Pessoa toFORM(PessoaRepository pessoaR, UsuarioRepository usuarioR) {
        Usuario usuario = usuarioR.getById(id_usuario);
        Pessoa pessoa = new Pessoa(nome, cpf, cep, endereco, complemento, numero, telefone, dt_nascimento, usuario);
        pessoaR.save(pessoa);
        return pessoa;

    }

    @Transactional
    public void SaveImageFile(Long pessoaID, MultipartFile file, PessoaRepository pessoaR) {
        try {
            Byte[] bytes = new Byte[file.getBytes().length];
            Pessoa pessoa = pessoaR.getById(pessoaID);
            pessoa.setFoto(bytes);
            pessoaR.save(pessoa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}