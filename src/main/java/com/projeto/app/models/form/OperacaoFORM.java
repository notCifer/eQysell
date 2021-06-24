package com.projeto.app.models.form;

import com.projeto.app.models.Locatario;
import com.projeto.app.models.Operacao;
import com.projeto.app.repositories.OperacaoRepository;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

public class OperacaoFORM {

    @NotBlank
    private String nome;
    @NotBlank
    private String razaosocial; /* OPCIONAL */
    @OneToOne
    private Locatario response;
    private long cnpj; /* OPCIONAL */
    private Double cdr;

    /* ___________________________GETTERS and SETTERS___________________________ */
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
        return cdr;
    }

    public void setCdr(Double cdr) {
        this.cdr = cdr;
    }

    /* ___________________________TO FORM___________________________ */

    public Operacao toForm(OperacaoRepository operacaoR) {
        Operacao operacao = new Operacao(nome, razaosocial, response, cnpj,cdr);
        operacaoR.save(operacao);
        return operacao;
    }
}
