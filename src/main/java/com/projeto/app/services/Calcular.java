package com.projeto.app.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.projeto.app.models.Abl;
import com.projeto.app.models.Atividade;
import com.projeto.app.models.Gestao;
import com.projeto.app.models.Localizacao;
import com.projeto.app.models.Operacao;
import com.projeto.app.models.Piso;
import com.projeto.app.models.RelatorioBruto;
import com.projeto.app.models.RelatorioOperacao;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.models.gestao.PisoEnum;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.repositories.AblRepository;
import com.projeto.app.repositories.AtividadeRepository;
import com.projeto.app.repositories.GestaoRepository;
import com.projeto.app.repositories.LocalizacaoRepository;
import com.projeto.app.repositories.OperacaoRepository;
import com.projeto.app.repositories.PisoRepository;
import com.projeto.app.repositories.RelatorioOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Calcular {

    @Autowired
    private AtividadeRepository atividadeR;

    @Autowired
    private LocalizacaoRepository localizaR;

    @Autowired
    private AblRepository ablR;

    @Autowired
    private PisoRepository pisoR;

    public Double calcularPeloTipo(List<Gestao> dados) {
        Double total = 0.0;
        for (Gestao gestao : dados) {
            total += gestao.getValor();
        }
        return total;
    }

    public Double gerarBruto(GestaoRepository gestaoR, int tipo, Long mes, RelatorioBruto relatorio) {
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
        return total;
    }

    public List<RelatorioOperacao> gerarByOperacao(RelatorioBruto relatorio, RelatorioOperacaoRepository relatorioOpR,
            OperacaoRepository operacaoR, Long mes) {

        Double totalCRD = 0.0;

        List<Operacao> oList = operacaoR.findAll();
        for (Operacao operacao : oList) {
            totalCRD += operacao.getCdr();
        }
        for (Operacao operacao : oList) {
            Double totalSoma = 0.0;
            RelatorioOperacao relatorioOP = new RelatorioOperacao();
            relatorioOP.setOperacao(operacao);
            Double resultado = ((operacao.getCdr() * 100) / totalCRD) / 100;
            for (int i = 0; i < TipoEnum.values().length; i++) {
                switch (i) {
                    case 0:
                        relatorioOP.setSeg_limpeza(relatorio.getSeg_limpeza() * resultado);
                        totalSoma += relatorioOP.getSeg_limpeza();
                        break;
                    case 1:
                        relatorioOP.setSanepar(relatorio.getSanepar() * resultado);
                        totalSoma += relatorioOP.getSanepar();
                        break;
                    case 2:
                        relatorioOP.setMat_limpeza(relatorio.getMat_limpeza() * resultado);
                        totalSoma += relatorioOP.getMat_limpeza();
                        break;
                    case 3:
                        relatorioOP.setMarketing(relatorio.getMarketing() * resultado);
                        totalSoma += relatorioOP.getMarketing();
                        break;
                    case 4:
                        relatorioOP.setCont_praga(relatorio.getCont_praga() * resultado);
                        totalSoma += relatorioOP.getCont_praga();
                        break;
                    case 5:
                        relatorioOP.setHonorario(relatorio.getHonorario() * resultado);
                        totalSoma += relatorioOP.getHonorario();
                        break;
                    case 6:
                        relatorioOP.setEntreterimento(relatorio.getEntreterimento() * resultado);
                        totalSoma += relatorioOP.getEntreterimento();
                        break;
                    case 7:
                        relatorioOP.setColeta_lixo(relatorio.getColeta_lixo() * resultado);
                        totalSoma += relatorioOP.getColeta_lixo();
                        break;
                    case 8:
                        relatorioOP.setInternet(relatorio.getInternet() * resultado);
                        totalSoma += relatorioOP.getInternet();
                        break;
                    case 9:
                        relatorioOP.setMat_expediente(relatorio.getMat_expediente() * resultado);
                        totalSoma += relatorioOP.getMat_expediente();
                        break;
                    case 10:
                        relatorioOP.setManutencao(relatorio.getManutencao() * resultado);
                        totalSoma += relatorioOP.getManutencao();
                        break;
                    case 11:
                        relatorioOP.setImpostos(relatorio.getImpostos() * resultado);
                        totalSoma += relatorioOP.getImpostos();
                        break;
                    case 12:
                        relatorioOP.setLocacao(relatorio.getLocacao() * resultado);
                        totalSoma += relatorioOP.getLocacao();
                        break;
                    case 13:
                        relatorioOP.setSeguro(relatorio.getSeguro() * resultado);
                        totalSoma += relatorioOP.getSeguro();
                        break;
                    case 14:
                        relatorioOP.setCopel(relatorio.getCopel() * resultado);
                        totalSoma += relatorioOP.getCopel();
                        break;
                }
            }
            int Datames = mes.intValue();
            LocalDate mesDate = LocalDate.of(2021, Datames, 01);
            relatorioOP.setTotal(totalSoma);
            relatorioOP.setData(mesDate);
            relatorioOpR.save(relatorioOP);
        }
        return relatorioOpR.findAll();
    }

    public Double geraCRD(Double Abl, AtividadeEnum atividadeEnum, LocalizacaoEnum localizaEnum, PisoEnum pisoEnum) {

        Long atividadeLong = atividadeEnum.getId();
        Long converteA = atividadeLong - 1;
        Atividade atividade = atividadeR.findByTipo(converteA);
        Double atividadeValor = atividade.getPorcetagem();


        Long localizaLong = localizaEnum.getId();
        Long converteL = localizaLong - 1;
        Localizacao localizacao = localizaR.findByTipo(converteL);
        Double localizaValor = localizacao.getPercentual();

        Long pisoLong = pisoEnum.getId();
        Long converteP = pisoLong - 1;
        Piso piso = pisoR.findByTipo(converteP);
        Double pisoValor = piso.getPorcentagem();

        Double Abl2 = Abl + 0.4;
        Abl -= 0.4;
        Abl abl = ablR.findByValor(Abl, Abl2);
        Double ablValor = abl.getPorcento();

        Double porcetagem = atividadeValor * localizaValor * pisoValor * ablValor;

        return porcetagem;

    }


}

