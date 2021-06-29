package com.projeto.app.models.dto;

import com.projeto.app.models.SaneparPrivativa;
import com.projeto.app.models.gestao.TipoEnum;

public class SaneparPrivativaDTO {

    
    private TipoEnum opEnum;
    private Double inicial;
    private Double fechamento;
    private Double consumo;
    private Double valortotal;


    
    public TipoEnum getOpEnum() {
        return opEnum;
    }

   
    public void setOpEnum(TipoEnum opEnum) {
        this.opEnum = opEnum;
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

    public SaneparPrivativaDTO toDto(SaneparPrivativa saneparPrivativa){
        SaneparPrivativaDTO DTO = new SaneparPrivativaDTO();
        DTO.setConsumo(saneparPrivativa.getConsumo());
        DTO.setFechamento(saneparPrivativa.getFechamento());
        DTO.setInicial(saneparPrivativa.getInicial());
        DTO.setOpEnum(saneparPrivativa.getOpEnum());
        DTO.setValortotal(saneparPrivativa.getValortotal());
        return DTO;
    }














}