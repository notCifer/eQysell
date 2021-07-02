package com.projeto.app.models.form;

import java.time.LocalDate;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.services.EnumService;

public class GestaoFORM {

    private String descricao;
    private Double valor;
    private Long idTipo;

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

    public Long getidTipo() {
        return idTipo;
    }

    public void setidTipo(Long tipo) {
        this.idTipo = tipo;
    }

    public Gestao toFORM(GestaoRepository gestaoR, EnumService enumS) {
        LocalDate agora = LocalDate.now();
        TipoEnum tipo = enumS.findTipo(idTipo);
        Gestao gestao = new Gestao(descricao, valor, tipo, agora);
        gestaoR.save(gestao);
        return gestao;
    }

}