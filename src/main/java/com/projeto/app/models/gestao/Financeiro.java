package com.projeto.app.models.gestao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double seglimpeza;
    private Double sanepar;
    private Double matlimpeza;
    private Double copel;
    private Double marketing;
    private Double contpraga;
    private Double honorario;
    private Double entreterimento;
    private Double coleta;
    private Double internet;
    private Double matexpidiente;
    private Double manutencao;
    private Double impostos;
    private Double locacao;
    private Double seguro;

    public Financeiro() {

    }

    public Financeiro(Double seglimpeza, Double sanepar, Double matlimpeza, Double copel, Double marketing,
            Double contpraga, Double honorario, Double entreterimento, Double coleta, Double internet,
            Double matexpidiente, Double manutencao, Double impostos, Double locacao, Double seguro) {
        this.seglimpeza = seglimpeza;
        this.sanepar = sanepar;
        this.matlimpeza = matlimpeza;
        this.copel = copel;
        this.marketing = marketing;
        this.contpraga = contpraga;
        this.honorario = honorario;
        this.entreterimento = entreterimento;
        this.coleta = coleta;
        this.internet = internet;
        this.matexpidiente = matexpidiente;
        this.manutencao = manutencao;
        this.impostos = impostos;
        this.locacao = locacao;
        this.seguro = seguro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSeglimpeza() {
        return seglimpeza;
    }

    public void setSeglimpeza(Double seglimpeza) {
        this.seglimpeza = seglimpeza;
    }

    public Double getSanepar() {
        return sanepar;
    }

    public void setSanepar(Double sanepar) {
        this.sanepar = sanepar;
    }

    public Double getMatlimpeza() {
        return matlimpeza;
    }

    public void setMatlimpeza(Double matlimpeza) {
        this.matlimpeza = matlimpeza;
    }

    public Double getCopel() {
        return copel;
    }

    public void setCopel(Double copel) {
        this.copel = copel;
    }

    public Double getMarketing() {
        return marketing;
    }

    public void setMarketing(Double marketing) {
        this.marketing = marketing;
    }

    public Double getContpraga() {
        return contpraga;
    }

    public void setContpraga(Double contpraga) {
        this.contpraga = contpraga;
    }

    public Double getHonorario() {
        return honorario;
    }

    public void setHonorario(Double honorario) {
        this.honorario = honorario;
    }

    public Double getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(Double entreterimento) {
        this.entreterimento = entreterimento;
    }

    public Double getColeta() {
        return coleta;
    }

    public void setColeta(Double coleta) {
        this.coleta = coleta;
    }

    public Double getInternet() {
        return internet;
    }

    public void setInternet(Double internet) {
        this.internet = internet;
    }

    public Double getMatexpidiente() {
        return matexpidiente;
    }

    public void setMatexpidiente(Double matexpidiente) {
        this.matexpidiente = matexpidiente;
    }

    public Double getManutencao() {
        return manutencao;
    }

    public void setManutencao(Double manutencao) {
        this.manutencao = manutencao;
    }

    public Double getImpostos() {
        return impostos;
    }

    public void setImpostos(Double impostos) {
        this.impostos = impostos;
    }

    public Double getLocacao() {
        return locacao;
    }

    public void setLocacao(Double locacao) {
        this.locacao = locacao;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

}