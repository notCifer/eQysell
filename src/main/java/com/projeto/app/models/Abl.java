package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private Double porcento;

    public Abl() {
    }

    public Abl(Double valor, Double porcento) {
        this.valor = valor;
        this.porcento = porcento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPorcento() {
        return porcento;
    }

    public void setPorcento(Double porcento) {
        this.porcento = porcento;
    }

}