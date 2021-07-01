package com.projeto.app.models.form;

import com.projeto.app.models.Localizacao;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.repositories.LocalizacaoRepository;
import com.projeto.app.services.EnumService;

public class LocalizacaoFORM {

    private Long idEnum;
    private Double percentual;

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Long getIdEnum() {
        return idEnum;
    }

    public void setIdEnum(Long idEnum) {
        this.idEnum = idEnum;
    }

    public Localizacao toFORM(LocalizacaoRepository LR,EnumService enumS) {
        Double porcentagem = percentual / 100;
        LocalizacaoEnum localizacaoEnum = enumS.findLocaliza(idEnum);
        Localizacao localizacao = new Localizacao(porcentagem, localizacaoEnum);
        LR.save(localizacao);
        return localizacao;
    }
}
