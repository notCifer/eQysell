package com.projeto.app.models.form;

import com.projeto.app.models.Locatario;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.services.Calcular;
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
    private Double abl;
    private AtividadeEnum atividadeEnum;
    private LocalizacaoEnum localizaEnum;
    private PisoEnum pisoEnum;


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

    /* ___________________________TO FORM___________________________ */

    public Operacao toForm(OperacaoRepository operacaoR, Calcular calc) {
        Double totalCRD = 100000000.0;
        Double calcCRD = calc.geraCRD(abl, atividadeEnum, localizaEnum, pisoEnum);
        Double calculo = calcCRD * totalCRD;
        Double resultado = calculo * abl;
        Operacao operacao = new Operacao(nome, razaosocial, response, cnpj, resultado);
        operacaoR.save(operacao);
        return operacao;
    }
}
