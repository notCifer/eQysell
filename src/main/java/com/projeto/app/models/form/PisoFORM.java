package com.projeto.app.models.form;

import com.projeto.app.models.Piso;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.repositories.PisoRepository;

public class PisoFORM {

private Double porcentagem;
private PisoEnum piso;


    public Double getPorcentagem() {
        return porcentagem;
    }

    
    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    
    public PisoEnum getPiso() {
        return piso;
    }

    
    public void setPiso(PisoEnum piso) {
        this.piso = piso;
    }


    public Piso toFORM(PisoRepository PisoR) {
        Double porcento = porcentagem/100;
        Piso piso = new Piso(porcento,piso);
        PisoR.save(piso);
        return piso;

    }

}