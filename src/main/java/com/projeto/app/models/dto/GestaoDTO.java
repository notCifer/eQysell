package com.projeto.app.models.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.gestao.TipoEnum;

public class GestaoDTO {

    private String descricao;
    private Double valor;
    private TipoEnum tipo;
    private LocalDate dataCreate;

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

    public LocalDate getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(LocalDate dataCreate) {
        this.dataCreate = dataCreate;
    }

    public GestaoDTO toDTO(Gestao gestao) {
        GestaoDTO DTO = new GestaoDTO();
        DTO.setTipo(gestao.getTipo());
        DTO.setDescricao(gestao.getDescricao());
        DTO.setDataCreate(gestao.getDataCreate());
        DTO.setValor(gestao.getValor());
        return DTO;
    }

    public List<GestaoDTO> toDTO(List<Gestao> gList) {
        return gList.stream().map(gestao -> toDTO(gestao)).collect(Collectors.toList());
    }
}