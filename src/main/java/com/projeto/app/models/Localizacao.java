package com.projeto.app.models;

import com.projeto.app.models.gestao.Enum_Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double percentual;
    private Enum_Local local;

    public Localizacao(Double percentual, Enum_Local local) {
    }

    public Localizacao(Long id, Double percentual, Enum_Local local) {
        this.id = id;
        this.percentual = percentual;
        this.local = local;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
