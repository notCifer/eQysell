package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.projeto.app.models.gestao.TipoEnum;

@Entity
public class SaneparPrivativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoEnum opEnum;
    @ManyToOne
    private Operacao operacao;
    private Double inicial;
    private Double fechamento;
    private Double consumo;
    private Double valortotal;

    public SaneparPrivativa() {
    }

    public SaneparPrivativa(TipoEnum opEnum, Operacao operacao, Double inicial, Double fechamento, Double consumo,
            Double valortotal) {
        this.opEnum = opEnum;
        this.operacao = operacao;
        this.inicial = inicial;
        this.fechamento = fechamento;
        this.consumo = consumo;
        this.valortotal = valortotal;
    }

    public TipoEnum getOpEnum() {
        return opEnum;
    }

    public void setOpEnum(TipoEnum opEnum) {
        this.opEnum = opEnum;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Double getInicial() {
        return inicial;
    }

    public void setInicial(Double inicial) {
        this.inicial = inicial;
    }

    public Double getFechamento() {
        return fechamento;
    }

    public void setFechamento(Double fechamento) {
        this.fechamento = fechamento;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

}