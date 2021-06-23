package com.projeto.app.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projeto.app.models.gestao.TipoEnum;

@Entity
public class Gestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private TipoEnum tipo;
    private LocalDate dataCreate;

    public Gestao() {
    }

    public Gestao(String descricao, Double valor, TipoEnum tipo, LocalDate dataCreate) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.dataCreate = dataCreate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataCreate == null) ? 0 : dataCreate.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gestao other = (Gestao) obj;
        if (dataCreate == null) {
            if (other.dataCreate != null)
                return false;
        } else if (!dataCreate.equals(other.dataCreate))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tipo != other.tipo)
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GestaodeCustos [dataCreate=" + dataCreate + ", descricao=" + descricao + ", id=" + id + ", tipo=" + tipo
                + ", valor=" + valor + "]";
    }

    // --------------GETTERS and SETTERS--------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(LocalDate dataCreate) {
        this.dataCreate = dataCreate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}