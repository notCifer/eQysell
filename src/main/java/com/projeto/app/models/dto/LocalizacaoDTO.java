package com.projeto.app.models.dto;

import com.projeto.app.models.Localizacao;
import com.projeto.app.models.gestao.Enum_Local;

public class LocalizacaoDTO {

    private Double percentual;
    private Enum_Local local;

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

    public LocalizacaoDTO toDTO(Localizacao localizacao){
        LocalizacaoDTO DTO = new LocalizacaoDTO();
        DTO.setPercentual(localizacao.getPercentual());
        DTO.setLocal(localizacao.getLocal());
        return DTO;
    }
}
