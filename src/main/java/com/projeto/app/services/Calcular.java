package com.projeto.app.services;

import java.time.LocalDate;
import java.util.List;
import com.projeto.app.configs.services.EmailService;
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
            OperacaoRepository operacaoR, Long mes, EmailService email) {

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
            LocalDate mesDate = LocalDate.of(2021, Datames, 01);
            relatorioOP.setData(mesDate);
            relatorioOpR.save(relatorioOP);
            String relatorioString = relatorioOP.toString();
            String relatorioMes = relatorioOP.getData().toString();
            String realtorioOperacao = operacao.getNome();
            email.enviarEmail("eqysselproj@gmail.com", relatorioString,
                    "Relatorio do mês " + relatorioMes + " Operação :" + realtorioOperacao);
        }
        return relatorioOpR.findAll();
    }

    public Double geraCRD(Double Abl, AtividadeEnum atividadeEnum, LocalizacaoEnum localizaEnum, PisoEnum pisoEnum) {

        Long idAtividade = 0L;
        for (AtividadeEnum atividade : AtividadeEnum.values()) {
            if (atividadeEnum.getId() == atividade.getId()) {
                idAtividade = atividade.getId();
            }
        }
        Atividade atividade = atividadeR.findByTipo(idAtividade);
        Double atividadeValor = atividade.getPorcetagem();

        Long idLocaliza = 0L;
        for (LocalizacaoEnum localizacaoEnum : LocalizacaoEnum.values()) {
            if (localizaEnum.getId() == localizacaoEnum.getId()) {
                idLocaliza = localizacaoEnum.getId();
            }
        }
        Localizacao localizacao = localizaR.findByTipo(idLocaliza);
        Double localizaValor = localizacao.getPercentual();

        Long idPiso = 0L;
        for (PisoEnum pEnum : PisoEnum.values()) {
            if (pisoEnum.getId() == pEnum.getId()) {
                idPiso = pEnum.getId();
            }
        }
        Piso piso = pisoR.findByTipo(idPiso);
        Double pisoValor = piso.getPorcentagem();

        Double Abl2 = Abl + 1;
        Abl -= 1;
        Abl abl = ablR.findByValor(Abl, Abl2);
        Double ablValor = abl.getPorcento();

        Double porcetagem = atividadeValor * localizaValor * pisoValor * ablValor;

        return porcetagem;

    }

}

