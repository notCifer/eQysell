package com.projeto.app.models.gestao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double campo;

    public Double getCampo() {
        return campo;
    }

    public void setCampo(Double valor) {
        this.campo = valor;
    }
    
}