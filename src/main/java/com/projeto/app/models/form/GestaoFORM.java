package com.projeto.app.models.form;

import java.time.LocalDate;

import com.projeto.app.models.Gestao;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;

public class GestaoFORM {

    private String descricao;
    private Double valor;
    private TipoEnum tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public Gestao toFORM(GestaoRepository gestaoR){
        LocalDate agora = LocalDate.now();
        Gestao gestao = new Gestao(descricao, valor, tipo, agora);
        gestaoR.save(gestao);
        return gestao;
    }

}