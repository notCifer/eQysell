package com.projeto.app.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelatorioBruto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Double seg_limpeza;
    private Double sanepar;
    private Double mat_limpeza;
    private Double copel;
    private Double marketing;
    private Double cont_praga;
    private Double honorario;
    private Double entreterimento;
    private Double coleta_lixo;
    private Double internet;
    private Double mat_expediente;
    private Double manutencao;
    private Double impostos;
    private Double locacao;
    private Double seguro;
    private Double total;

    public RelatorioBruto() {
    }

    public RelatorioBruto(LocalDate data, Double seg_limpeza, Double sanepar, Double mat_limpeza, Double copel,
            Double marketing, Double cont_praga, Double honorario, Double entreterimento, Double coleta_lixo,
            Double internet, Double mat_expediente, Double manutencao, Double impostos, Double locacao, Double seguro,
            Double total) {
        this.data = data;
        this.seg_limpeza = seg_limpeza;
        this.sanepar = sanepar;
        this.mat_limpeza = mat_limpeza;
        this.copel = copel;
        this.marketing = marketing;
        this.cont_praga = cont_praga;
        this.honorario = honorario;
        this.entreterimento = entreterimento;
        this.coleta_lixo = coleta_lixo;
        this.internet = internet;
        this.mat_expediente = mat_expediente;
        this.manutencao = manutencao;
        this.impostos = impostos;
        this.locacao = locacao;
        this.seguro = seguro;
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getSeg_limpeza() {
        return seg_limpeza;
    }

    public void setSeg_limpeza(Double seg_limpeza) {
        this.seg_limpeza = seg_limpeza;
    }

    public Double getSanepar() {
        return sanepar;
    }

    public void setSanepar(Double sanepar) {
        this.sanepar = sanepar;
    }

    public Double getMat_limpeza() {
        return mat_limpeza;
    }

    public void setMat_limpeza(Double mat_limpeza) {
        this.mat_limpeza = mat_limpeza;
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

    public Double getCont_praga() {
        return cont_praga;
    }

    public void setCont_praga(Double cont_praga) {
        this.cont_praga = cont_praga;
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

    public Double getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(Double coleta_lixo) {
        this.coleta_lixo = coleta_lixo;
    }

    public Double getInternet() {
        return internet;
    }

    public void setInternet(Double internet) {
        this.internet = internet;
    }

    public Double getMat_expediente() {
        return mat_expediente;
    }

    public void setMat_expediente(Double mat_expediente) {
        this.mat_expediente = mat_expediente;
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