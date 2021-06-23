package com.projeto.app.models.form;

import java.util.List;

import com.projeto.app.models.gestao.Dados;
import com.projeto.app.models.gestao.TipoEnum;
import com.projeto.app.models.gestao.Valor;

public class FinanceiroFORM {

    private Dados seg_limpeza;
    private Dados sanepar;
    private Dados mat_limpeza;
    private Dados marketing;
    private Dados honorario;
    private Dados coleta_lixo;
    private Dados internet;
    private Dados manutencao;
    private Dados locacao;

    public Dados getSeg_limpeza() {
        return seg_limpeza;
    }

    public void setSeg_limpeza(Dados seg_limpeza) {
        TipoEnum descricao;
        descricao = TipoEnum.SEG_LIMPEZA;
        if (seg_limpeza.getEscolha().equals(descricao)) {
            this.seg_limpeza = seg_limpeza;
        }
    }

    public Dados getSanepar() {
        return sanepar;
    }

    public void setSanepar(Dados sanepar) {
        TipoEnum descricao;
        descricao = TipoEnum.SANEPAR;
        if (sanepar.getEscolha().equals(descricao)) {
            this.sanepar = sanepar;
        }
    }

    public Dados getMat_Limpeza() {
        return mat_limpeza;
    }

    public void setMat_Limpeza(Dados mat_limpeza) {
        TipoEnum descricao;
        descricao = TipoEnum.MAT_LIMPEZA;
        if (mat_limpeza.getEscolha().equals(descricao)) {
            this.mat_limpeza = mat_limpeza;
        }
    }

    public Dados getMarketing() {
        return marketing;
    }

    public void setMarketing(Dados marketing) {
        TipoEnum descricao;
        descricao = TipoEnum.MARKETING;
        if (marketing.getEscolha().equals(descricao)) {
            this.marketing = marketing;
        }
    }

    public Dados getHonorario() {
        return honorario;
    }

    public void setHonorario(Dados honorario) {
        TipoEnum descricao;
        descricao = TipoEnum.HONORARIOS;
        if (honorario.getEscolha().equals(descricao)) {
            this.honorario = honorario;
        }
    }

    public Dados getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(Dados coleta_lixo) {
        TipoEnum descricao;
        descricao = TipoEnum.COLETA_LIXO;
        if (coleta_lixo.getEscolha().equals(descricao)) {
            this.coleta_lixo = coleta_lixo;
        }
    }

    public Dados getInternet() {
        return internet;
    }

    public void setInternet(Dados internet) {
        TipoEnum descricao;
        descricao = TipoEnum.INTERNET;
        if (internet.getEscolha().equals(descricao)) {
            this.internet = internet;
        }
    }

    public Dados getManutencao() {
        return manutencao;
    }

    public void setManutencao(Dados manutencao) {
        TipoEnum descricao;
        descricao = TipoEnum.MANUTENÇÃO;
        if (manutencao.getEscolha().equals(descricao)) {
            this.manutencao = manutencao;
        }
    }

    public Dados getLocacao() {
        return locacao;
    }

    public void setLocacao(Dados locacao) {
        TipoEnum descricao;
        descricao = TipoEnum.MANUTENÇÃO;
        if (locacao.getEscolha().equals(descricao)) {
            this.locacao = locacao;
        }
    }

    public Double mostrar() {
        Double SEG_LIMPEZA = Somar(seg_limpeza);
        Double SANEPAR = Somar(sanepar);
        Double MAT_LIMPEZA = Somar(mat_limpeza);
        Double MARKETING = Somar(marketing);
        Double HONORARIO = Somar(honorario);
        Double COLETA_LIXO = Somar(coleta_lixo);
        Double INTERNET = Somar(internet);
        Double MANUTENCAO = Somar(manutencao);
        Double LOCACAO = Somar(locacao);
        Double total = SEG_LIMPEZA + SANEPAR + MAT_LIMPEZA + MARKETING + HONORARIO + COLETA_LIXO + INTERNET + MANUTENCAO
                + LOCACAO;
        return total;
    }

    public Double Somar(Dados dados) {
        List<Valor> valores = dados.getValor();
        Double total = 0.0;
        for (Valor valor : valores) {
            total += valor.getCampo();
        }
        System.out.println(total);
        return total;
    }

}