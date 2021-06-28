package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.projeto.app.models.gestao.AtividadeEnum;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private AtividadeEnum atividade;
    private Double porcetagem;

    public Atividade() {
    }

    public Atividade(AtividadeEnum atividade, Double porcetagem) {
        this.atividade = atividade;
        this.porcetagem = porcetagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtividadeEnum getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeEnum atividade) {
        this.atividade = atividade;
    }

    public Double getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(Double porcetagem) {
        this.porcetagem = porcetagem;
    }

}