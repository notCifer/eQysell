package com.projeto.app.models.form;

import com.projeto.app.models.Localizacao;
import com.projeto.app.models.gestao.Enum_Local;
import com.projeto.app.repositories.LocalizacaoRepository;

public class LocalizacaoFORM {

    private Double percentual;
    private Enum_Local local;



    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Enum_Local getLocal() {
        return local;
    }

    public void setLocal(Enum_Local local) {
        this.local = local;
    }

    public Localizacao toForm(LocalizacaoRepository LR){
        Double porcentagem = percentual/100;
        Localizacao localizacao = new Localizacao(porcentagem, local);
        LR.save(localizacao);
        return localizacao;
    }
}
