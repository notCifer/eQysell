package com.projeto.app.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financeiro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Double> seglimpeza;
    private List<Double> sanepar;
    private List<Double> matlimpeza;
    private List<Double> copel;
    private List<Double> marketing;
    private List<Double> contpraga;
    private List<Double> honorario;
    private List<Double> entreterimento;
    private List<Double> coleta;
    private List<Double> internet;
    private List<Double> matexpidiente;
    private List<Double> manutencao;
    private List<Double> impostos;
    private List<Double> locacao;
    private List<Double> seguro;

    public Financeiro() {
    }

    public Financeiro(List<Double> seglimpeza, List<Double> sanepar, List<Double> matlimpeza, List<Double> copel,
            List<Double> marketing, List<Double> contpraga, List<Double> honorario, List<Double> entreterimento,
            List<Double> coleta, List<Double> internet, List<Double> matexpidiente, List<Double> manutencao,
            List<Double> impostos, List<Double> locacao, List<Double> seguro) {
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

    public List<Double> getSeglimpeza() {
        return seglimpeza;
    }

    public void setSeglimpeza(List<Double> seglimpeza) {
        this.seglimpeza = seglimpeza;
    }

    public List<Double> getSanepar() {
        return sanepar;
    }

    public void setSanepar(List<Double> sanepar) {
        this.sanepar = sanepar;
    }

    public List<Double> getMatlimpeza() {
        return matlimpeza;
    }

    public void setMatlimpeza(List<Double> matlimpeza) {
        this.matlimpeza = matlimpeza;
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

    public List<Double> getContpraga() {
        return contpraga;
    }

    public void setContpraga(List<Double> contpraga) {
        this.contpraga = contpraga;
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

    public List<Double> getColeta() {
        return coleta;
    }

    public void setColeta(List<Double> coleta) {
        this.coleta = coleta;
    }

    public List<Double> getInternet() {
        return internet;
    }

    public void setInternet(List<Double> internet) {
        this.internet = internet;
    }

    public List<Double> getMatexpidiente() {
        return matexpidiente;
    }

    public void setMatexpidiente(List<Double> matexpidiente) {
        this.matexpidiente = matexpidiente;
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

    
 
    

}