package com.projeto.app.models.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.projeto.app.models.Financeiro;
import com.projeto.app.repositories.FinanceiroRepository;

public class FinanceiroFORM {

    @NotNull
    private List<Double> seg_limpeza;
    @NotNull
    private List<Double> sanepar;
    @NotNull
    private List<Double> mat_limpeza;
    @NotNull
    private List<Double> copel;
    @NotNull
    private List<Double> marketing;
    @NotNull
    private List<Double> cont_praga;
    @NotNull
    private List<Double> honorario;
    @NotNull
    private List<Double> entreterimento;
    @NotNull
    private List<Double> coleta_lixo;
    @NotNull
    private List<Double> internet;
    @NotNull
    private List<Double> mat_expidiente;
    @NotNull
    private List<Double> manutencao;
    @NotNull
    private List<Double> impostos;
    @NotNull
    private List<Double> locacao;
    @NotNull
    private List<Double> seguro;

    public List<Double> getSeg_limpeza() {
        return seg_limpeza;
    }

    public void setSeg_limpeza(List<Double> seg_limpeza) {
        this.seg_limpeza = seg_limpeza;
    }

    public List<Double> getSanepar() {
        return sanepar;
    }

    public void setSanepar(List<Double> sanepar) {
        this.sanepar = sanepar;
    }

    public List<Double> getMat_limpeza() {
        return mat_limpeza;
    }

    public void setMat_limpeza(List<Double> mat_limpeza) {
        this.mat_limpeza = mat_limpeza;
    }

    public List<Double> getCopel() {
        return copel;
    }

    public void setCopel(List<Double> copel) {
        this.copel = copel;
    }

    public List<Double> getMarketing() {
        return marketing;
    }

    public void setMarketing(List<Double> marketing) {
        this.marketing = marketing;
    }

    public List<Double> getCont_praga() {
        return cont_praga;
    }

    public void setCont_praga(List<Double> cont_praga) {
        this.cont_praga = cont_praga;
    }

    public List<Double> getHonorario() {
        return honorario;
    }

    public void setHonorario(List<Double> honorario) {
        this.honorario = honorario;
    }

    public List<Double> getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(List<Double> entreterimento) {
        this.entreterimento = entreterimento;
    }

    public List<Double> getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(List<Double> coleta_lixo) {
        this.coleta_lixo = coleta_lixo;
    }

    public List<Double> getInternet() {
        return internet;
    }

    public void setInternet(List<Double> internet) {
        this.internet = internet;
    }

    public List<Double> getMat_expidiente() {
        return mat_expidiente;
    }

    public void setMat_expidiente(List<Double> mat_expidiente) {
        this.mat_expidiente = mat_expidiente;
    }

    public List<Double> getManutencao() {
        return manutencao;
    }

    public void setManutencao(List<Double> manutencao) {
        this.manutencao = manutencao;
    }

    public List<Double> getImpostos() {
        return impostos;
    }

    public void setImpostos(List<Double> impostos) {
        this.impostos = impostos;
    }

    public List<Double> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Double> locacao) {
        this.locacao = locacao;
    }

    public List<Double> getSeguro() {
        return seguro;
    }

    public void setSeguro(List<Double> seguro) {
        this.seguro = seguro;
    }

    public Financeiro toFORM(FinanceiroRepository financeiroR) {
        Financeiro financeiro = new Financeiro(seg_limpeza, sanepar, mat_limpeza, copel, marketing, cont_praga,
                honorario, entreterimento, coleta_lixo, internet, mat_expidiente, manutencao, impostos, locacao,
                seguro);
        financeiroR.save(financeiro);
        return financeiro;
    }

}