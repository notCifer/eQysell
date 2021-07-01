package com.projeto.app.models.dto;

import com.projeto.app.models.Piso;
import com.projeto.app.models.gestao.PisoEnum;

public class PisoDTO {

    private Double porcentagem;
    private PisoEnum piso;

    
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

    public PisoDTO toDTO(Piso piso) {
        PisoDTO DTO = new PisoDTO();
        DTO.setPiso(piso.getPiso());
        DTO.setPorcentagem(piso.getPorcentagem());
        return DTO;
    }

}