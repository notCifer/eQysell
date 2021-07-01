package com.projeto.app.models.form;

import javax.validation.constraints.NotNull;
import com.projeto.app.models.Abl;
import com.projeto.app.repositories.AblRepository;

public class AblFORM {

    @NotNull
    private Double valor;
    @NotNull
    private Double porcento;

    public AblFORM() {
    }

    public AblFORM(Double valor, Double porcento) {
        this.valor = valor;
        this.porcento = porcento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPorcento() {
        return porcento;
    }

    public void setPorcento(Double porcento) {
        this.porcento = porcento;
    }

    public Abl toFORM(AblRepository ablR) {
        Double porcentagem = porcento / 100;
        Abl abl = new Abl(valor, porcentagem);
        ablR.save(abl);
        return abl;
    }

}