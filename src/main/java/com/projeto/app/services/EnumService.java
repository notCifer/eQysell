package com.projeto.app.services;

import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.models.gestao.TipoEnum;

import org.springframework.stereotype.Service;

@Service
public class EnumService {

    public AtividadeEnum findAtividade(Long id) {
        AtividadeEnum[] list = AtividadeEnum.values();
        for (AtividadeEnum atividadeEnum : list) {
            if (id == atividadeEnum.getId()) {
                return atividadeEnum;
            }
        }
        return null;
    }

    public PisoEnum findPiso(Long id) {
        PisoEnum[] list = PisoEnum.values();
        for (PisoEnum pisoEnum2 : list) {
            if (id == pisoEnum2.getId()) {
                return pisoEnum2;
            }
        }
        return null;
    }

    public LocalizacaoEnum findLocaliza(Long id) {
        LocalizacaoEnum[] list = LocalizacaoEnum.values();
        for (LocalizacaoEnum localizacaoEnum : list) {
            if (id == localizacaoEnum.getId()) {
                return localizacaoEnum;
            }
        }
        


        return null;
    }

    public TipoEnum findSaneparP(Long id) {
        TipoEnum[] list = TipoEnum.values();
        for (TipoEnum tipoEnum : list) {
            if (id == tipoEnum.getId()) {
                return tipoEnum;
            }
        }
        

        return null;
    }

}
