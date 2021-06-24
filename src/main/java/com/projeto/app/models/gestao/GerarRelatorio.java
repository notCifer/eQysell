package com.projeto.app.models.gestao;

import java.util.List;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.Relatorio;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.services.Calcular;
import org.springframework.stereotype.Service;

@Service
public class GerarRelatorio {

    public Relatorio inserirDados(GestaoRepository gestaoR, Calcular calc, int tipo, Long mes, Relatorio relatorio) {
        List<Gestao> lista = gestaoR.findAllBy(tipo, mes);
        Double total = calc.calcularPeloTipo(lista);
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