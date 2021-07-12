package com.projeto.app.models.form;

import com.projeto.app.models.Locatario;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.repositories.LocatarioRepository;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.services.Calcular;
import com.projeto.app.services.EnumService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OperacaoFORM {

    @NotBlank
    private String nome;
    private String razaosocial; /* OPCIONAL */
    private long cnpj; /* OPCIONAL */
    @NotNull
    private Double abl;
    @NotNull
    private Long atividade;
    @NotNull
    private Long localiza;
    @NotNull
    private Long piso;
    @NotNull
    private Long response;

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

    public Long getResponse() {
        return response;
    }

    public void setResponse(Long response) {
        this.response = response;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Double getAbl() {
        return abl;
    }

    public void setAbl(Double abl) {
        this.abl = abl;
    }

    public Long getAtividade() {
        return atividade;
    }

    public void setAtividade(Long atividade) {
        this.atividade = atividade;
    }

    public Long getLocaliza() {
        return localiza;
    }

    public void setLocaliza(Long localiza) {
        this.localiza = localiza;
    }

    public Long getPiso() {
        return piso;
    }

    public void setPiso(Long piso) {
        this.piso = piso;
    }

    /* ___________________________TO FORM___________________________ */

    public Operacao toFORM(OperacaoRepository operacaoR, EnumService enumS, Calcular calc, LocatarioRepository locatarioR) {
        Optional<Locatario> findById = locatarioR.findById(response);
        if (findById.isPresent()) {
            Locatario locatario = findById.get();
            Double totalCRD = 1.0;
            LocalizacaoEnum localizaEnum = enumS.findLocaliza(localiza);
            PisoEnum pisoEnum = enumS.findPiso(piso);
            AtividadeEnum atividadeEnum = enumS.findAtividade(atividade);
    
            Double calcCRD = calc.geraCRD(abl, atividadeEnum, localizaEnum, pisoEnum);
            Double calculo = calcCRD * totalCRD;
            Double resultado = calculo * abl;
            BigDecimal bd = new BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP);
            Operacao operacao = new Operacao(nome, razaosocial, locatario, cnpj, bd.doubleValue());
            operacaoR.save(operacao);
            return operacao;
        }
        return null;
    }

    public Double toAlter(OperacaoRepository operacaoR, EnumService enumS, Calcular calc, Operacao operacao, Double abls) {
        Double totalCRD = 1.0;
        LocalizacaoEnum localizaEnum = enumS.findLocaliza(localiza);
        PisoEnum pisoEnum = enumS.findPiso(piso);
        AtividadeEnum atividadeEnum = enumS.findAtividade(atividade);
        
        Double calcCRD = calc.geraCRD(abls, atividadeEnum, localizaEnum, pisoEnum);
        Double calculo = calcCRD * totalCRD;
        Double resultado = calculo * abls;
        return resultado;
    }
}
