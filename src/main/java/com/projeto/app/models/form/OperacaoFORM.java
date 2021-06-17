package com.projeto.app.models.form;

import com.projeto.app.models.Operacao;
import com.projeto.app.repositories.OperacaoRepository;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToMany;
//###############################################################################//

public class OperacaoFORM {

    @NotBlank
    private String nome;
    private String razaosocial;

    //Existe aqui? or @ManytoMany ?
    //@OneToMany
    @NotEmpty @NotNull
    private Locatario response;
    private long cnpj;

    //###############################################################################//
    //toForm
    public Operacao toForm(OperacaoRepository operacaoR){
        Operacao operacao = new Operacao(nome, razaosocial, response, cnpj);
        operacaoR.save(operacao);
        return operacao;
    }
    //###############################################################################//
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
}
