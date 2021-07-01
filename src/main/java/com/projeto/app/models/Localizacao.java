package com.projeto.app.models;

import com.projeto.app.models.gestao.LocalizacaoEnum;
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
    private LocalizacaoEnum local;

    public Localizacao() {
    }

    public Localizacao(Double percentual, LocalizacaoEnum local) {
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

    public LocalizacaoEnum getLocal() {
        return local;
    }

    public void setLocal(LocalizacaoEnum local) {
        this.local = local;
    }
}
