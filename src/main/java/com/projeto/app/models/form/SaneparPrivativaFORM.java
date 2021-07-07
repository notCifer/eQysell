package com.projeto.app.models.form;

import java.util.Optional;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.SaneparPrivativa;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.repositories.SaneparPrivativaRepository;
import com.projeto.app.services.EnumService;

public class SaneparPrivativaFORM {

    private Long idEnum;
    private Double inicial;
    private Double fechamento;
    private Long idOperaLong;
   
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

    
    public Long getIdOperaLong() {
        return idOperaLong;
    }


    public void setIdOperaLong(Long idOperaLong) {
        this.idOperaLong = idOperaLong;
    }


    public SaneparPrivativa ToFORM(SaneparPrivativaRepository SaneparPR, EnumService opEnum, OperacaoRepository operacaoR){
        Optional<Operacao> Find = operacaoR.findById(idOperaLong);
        if (Find.isPresent()) {
            Operacao operacao = Find.get();
            Double consumo = fechamento - inicial;
            Double valorTotal = consumo * 17.11 ;
            TipoEnum Tipo = opEnum.findTipo(idEnum);
            SaneparPrivativa saneparPrivativa = new SaneparPrivativa(Tipo, operacao,inicial, fechamento, consumo,valorTotal);
            SaneparPR.save(saneparPrivativa);
            return saneparPrivativa;  
        }
        return null;
    }


}