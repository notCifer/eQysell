package com.projeto.app.services;

import java.time.LocalDate;
import java.util.List;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.RelatorioBruto;
import com.projeto.app.models.RelatorioOperacao;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.repositories.RelatorioOperacaoRepository;
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

    public RelatorioBruto gerarBruto(GestaoRepository gestaoR, int tipo, Long mes, RelatorioBruto relatorio) {
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
        int Datames = mes.intValue();
        LocalDate mesDate = LocalDate.of(2001, Datames, 01);
        relatorio.setData(mesDate);
        return relatorio;
    }

    public List<RelatorioOperacao> gerarByOperacao(RelatorioBruto relatorio, RelatorioOperacaoRepository relatorioOpR,
            OperacaoRepository operacaoR, Long mes) {

        Double totalCRD = 0.0;

        List<Operacao> oList = operacaoR.findAll();
        for (Operacao operacao : oList) {
            totalCRD += operacao.getCdr();
        }
        for (Operacao operacao : oList) {
            RelatorioOperacao relatorioOP = new RelatorioOperacao();

            Double resultado = ((operacao.getCdr() * 100) / totalCRD) / 100;
            for (int i = 0; i < TipoEnum.values().length; i++) {
                switch (i) {
                    case 0:
                        relatorioOP.setSeg_limpeza(relatorio.getSeg_limpeza() * resultado);
                        break;
                    case 1:
                        relatorioOP.setSanepar(relatorio.getSanepar() * resultado);
                        break;
                    case 2:
                        relatorioOP.setMat_limpeza(relatorio.getMat_limpeza() * resultado);
                        break;
                    case 3:
                        relatorioOP.setMarketing(relatorio.getMarketing() * resultado);
                        break;
                    case 4:
                        relatorioOP.setCont_praga(relatorio.getCont_praga() * resultado);
                        break;
                    case 5:
                        relatorioOP.setHonorario(relatorio.getHonorario() * resultado);
                        break;
                    case 6:
                        relatorioOP.setEntreterimento(relatorio.getEntreterimento() * resultado);
                        break;
                    case 7:
                        relatorioOP.setColeta_lixo(relatorio.getColeta_lixo() * resultado);
                        break;
                    case 8:
                        relatorioOP.setInternet(relatorio.getInternet() * resultado);
                        break;
                    case 9:
                        relatorioOP.setMat_expediente(relatorio.getMat_expediente() * resultado);
                        break;
                    case 10:
                        relatorioOP.setManutencao(relatorio.getManutencao() * resultado);
                        break;
                    case 11:
                        relatorioOP.setImpostos(relatorio.getImpostos() * resultado);
                        break;
                    case 12:
                        relatorioOP.setLocacao(relatorio.getLocacao() * resultado);
                        break;
                    case 13:
                        relatorioOP.setSeguro(relatorio.getSeguro() * resultado);
                        break;
                    case 14:
                        relatorioOP.setCopel(relatorio.getCopel() * resultado);
                        break;
                }
            }
            int Datames = mes.intValue();
            LocalDate mesDate = LocalDate.of(2001, Datames, 01);
            relatorioOP.setData(mesDate);
            relatorioOpR.save(relatorioOP);
        }
        return relatorioOpR.findAll();
    }
}