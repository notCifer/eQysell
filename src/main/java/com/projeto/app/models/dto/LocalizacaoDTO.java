package com.projeto.app.models.dto;

import com.projeto.app.models.Localizacao;
import com.projeto.app.models.gestao.LocalizacaoEnum;

public class LocalizacaoDTO {

    private Double percentual;
    private LocalizacaoEnum local;

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

    public LocalizacaoDTO toDTO(Localizacao localizacao){
        LocalizacaoDTO DTO = new LocalizacaoDTO();
        DTO.setPercentual(localizacao.getPercentual());
        DTO.setLocal(localizacao.getLocal());
        return DTO;
    }
}
