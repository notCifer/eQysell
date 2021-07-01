package com.projeto.app.models.form;

import com.projeto.app.models.SaneparPrivativa;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.SaneparPrivativaRepository;
import com.projeto.app.services.EnumService;

public class SaneparPrivativaFORM {

    private Long idEnum;
    private Double inicial;
    private Double fechamento;
   
    

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

    public Long getIdEnum() {
        return idEnum;
    }

    
    public void setIdEnum(Long idEnum) {
        this.idEnum = idEnum;
    }

    
    public SaneparPrivativa ToFORM(SaneparPrivativaRepository SaneparPR, EnumService opEnum ){
        Double consumo = fechamento - inicial;
        Double valorTotal = consumo * 17.11 ;
        TipoEnum Tipo = opEnum.findSaneparP(idEnum);
        SaneparPrivativa saneparPrivativa = new SaneparPrivativa(Tipo, inicial, fechamento, consumo,valorTotal);
        SaneparPR.save(saneparPrivativa);
        return saneparPrivativa;

    }


}