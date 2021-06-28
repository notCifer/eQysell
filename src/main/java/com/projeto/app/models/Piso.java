package com.projeto.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.projeto.app.models.gestao.PisoEnum;

@Entity
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double porcentagem;
    private PisoEnum piso;

    /* ___________________________CONSTRUCTOR___________________________ */

    public Piso(Double porcentagem, PisoEnum piso) {
        this.porcentagem = porcentagem;
        this.piso = piso;
    }

    public Piso() {
    }

    /* ___________________________GETTERS and SETTERS ___________________________ */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public PisoEnum getPiso() {
        return piso;
    }

    public void setPiso(PisoEnum piso) {
        this.piso = piso;
    }

}