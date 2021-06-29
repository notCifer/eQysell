package com.projeto.app.models;

import javax.persistence.*;

@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String razaosocial;

    @ManyToOne(cascade = CascadeType.ALL)
    private Locatario response;
    private long cnpj;
    private Double crd;

    /* ___________________________CONSTRUTOR___________________________ */

    public Operacao() {
    }

    public Operacao(String nome, String razaosocial, Locatario response, long cnpj, Double cdr) {
        this.nome = nome;
        this.razaosocial = razaosocial;
        this.response = response;
        this.cnpj = cnpj;
        this.crd = cdr;
    }

    /* ___________________________GETTERS and SETTERS___________________________ */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public Locatario getResponse() {
        return response;
    }

    public void setResponse(Locatario response) {
        this.response = response;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Double getCdr() {
        return crd;
    }

    public void setCdr(Double cdr) {
        this.crd = cdr;
    }

}
