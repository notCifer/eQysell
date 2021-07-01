package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projeto.app.models.gestao.TipoEnum;

@Entity
public class SaneparPrivativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TipoEnum opEnum;
    private Double inicial;
    private Double fechamento;
    private Double consumo;
    private Double valortotal;


    public SaneparPrivativa() {
    }


    public SaneparPrivativa(TipoEnum opEnum, Double inicial, Double fechamento, Double consumo, Double valortotal) {
        this.opEnum = opEnum;
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

   
    public Double getInicial() {
        return inicial;
    }

   
    public void setInicial(Double inical) {
        this.inicial = inical;
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