package com.projeto.app.models.form;

import com.projeto.app.models.Localizacao;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.repositories.LocalizacaoRepository;

public class LocalizacaoFORM {

    private Double percentual;
    private LocalizacaoEnum local;



    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public LocalizacaoEnum getLocal() {
        return local;
    }

    public void setLocal(LocalizacaoEnum local) {
        this.local = local;
    }

    public Localizacao toForm(LocalizacaoRepository LR){
        Double porcentagem = percentual/100;
        Localizacao localizacao = new Localizacao(porcentagem, local);
        LR.save(localizacao);
        return localizacao;
    }
}
