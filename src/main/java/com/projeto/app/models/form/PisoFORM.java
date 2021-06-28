package com.projeto.app.models.form;

import com.projeto.app.models.Piso;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.repositories.PisoRepository;

public class PisoFORM {

    private Double porcentagem;
    private PisoEnum pisoEnum;

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public PisoEnum getPiso() {
        return pisoEnum;
    }

    public void setPiso(PisoEnum piso) {
        this.pisoEnum = piso;
    }

    public Piso toFORM(PisoRepository PisoR) {
        Double porcento = porcentagem / 100;
        Piso piso = new Piso(porcento, pisoEnum);
        PisoR.save(piso);
        return piso;

    }

}