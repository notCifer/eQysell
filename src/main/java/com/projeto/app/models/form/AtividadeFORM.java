package com.projeto.app.models.form;

import javax.validation.constraints.NotNull;
import com.projeto.app.models.Atividade;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.repositories.AtividadeRepository;
import com.projeto.app.services.EnumService;

public class AtividadeFORM {

    @NotNull
    private Long idEnum;
    @NotNull
    private Double porcetagem;

    public Long getIdEnum() {
        return idEnum;
    }

    public void setIdEnum(Long idEnum) {
        this.idEnum = idEnum;
    }

    public Double getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(Double porcetagem) {
        this.porcetagem = porcetagem;
    }

    public Atividade toFORM(AtividadeRepository atividadeR,EnumService enumS) {
        AtividadeEnum atividadeEnum = enumS.findAtividade(idEnum);
        Double porcento = porcetagem / 100;
        Atividade atividade = new Atividade(atividadeEnum, porcento);
        atividadeR.save(atividade);
        return atividade;
    }

}