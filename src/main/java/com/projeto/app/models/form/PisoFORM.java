package com.projeto.app.models.form;

import com.projeto.app.models.Piso;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.repositories.PisoRepository;
import com.projeto.app.services.EnumService;

public class PisoFORM {

    private Long idEnum;
    private Double porcentagem;

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Long getIdEnum() {
        return idEnum;
    }

    public void setIdEnum(Long idEnum) {
        this.idEnum = idEnum;
    }

    public Piso toFORM(PisoRepository PisoR,EnumService enumS) {
        Double porcento = porcentagem / 100;
        PisoEnum pisoEnum = enumS.findPiso(idEnum);
        Piso piso = new Piso(porcento, pisoEnum);
        PisoR.save(piso);
        return piso;
    }

}