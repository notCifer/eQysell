package com.projeto.app.services;

import java.util.List;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.Relatorio;
import com.projeto.app.repositories.GestaoRepository;

import org.springframework.stereotype.Service;

@Service
public class Calcular {

    public Double calcularPeloTipo(List<Gestao> dados) {
        Double total = 0.0;
        for (Gestao gestao : dados) {
            total += gestao.getValor();
        }
        return total;
    }

    public Relatorio inserirDados(GestaoRepository gestaoR, int tipo, Long mes, Relatorio relatorio) {
        List<Gestao> lista = gestaoR.findAllBy(tipo, mes);
        Double total = calcularPeloTipo(lista);
        switch (tipo) {
            case 0:
                relatorio.setSeg_limpeza(total);
                break;
            case 1:
                relatorio.setSanepar(total);
                break;
            case 2:
                relatorio.setMat_limpeza(total);
                break;
            case 3:
                relatorio.setMarketing(total);
                break;
            case 4:
                relatorio.setCont_praga(total);
                break;
            case 5:
                relatorio.setHonorario(total);
                break;
            case 6:
                relatorio.setEntreterimento(total);
                break;
            case 7:
                relatorio.setColeta_lixo(total);
                break;
            case 8:
                relatorio.setInternet(total);
                break;
            case 9:
                relatorio.setMat_expediente(total);
                break;
            case 10:
                relatorio.setManutencao(total);
                break;
            case 11:
                relatorio.setImpostos(total);
                break;
            case 12:
                relatorio.setLocacao(total);
                break;
            case 13:
                relatorio.setSeguro(total);
                break;
            case 14:
                relatorio.setCopel(total);
                break;
        }
        return relatorio;
    }


}