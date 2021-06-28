package com.projeto.app.models.form;

import javax.validation.constraints.NotNull;

import com.projeto.app.models.Atividade;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.repositories.AtividadeRepository;

public class AtividadeFORM {

    @NotNull
    private AtividadeEnum atividadeEnum;
    @NotNull
    private Double porcetagem;

    public AtividadeEnum getAtividade() {
        return atividadeEnum;
    }

    public void setAtividade(AtividadeEnum atividade) {
        this.atividadeEnum = atividade;
    }

    public Double getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(Double porcetagem) {
        this.porcetagem = porcetagem;
    }

    public Atividade toFORM(AtividadeRepository atividadeR) {
        Atividade atividade = new Atividade(atividadeEnum, porcetagem);
        atividadeR.save(atividade);
        return atividade;

    }

}