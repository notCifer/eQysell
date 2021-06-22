package com.projeto.app.models.form;

import java.util.List;

import com.projeto.app.models.gestao.Dados;
import com.projeto.app.models.gestao.Descricao;
import com.projeto.app.models.gestao.Valor;

public class FinanceiroFORM {

    private Dados seg_limpeza;

    private Dados sanepar;

    private Dados copel;

    private Dados cont_praga;

    private Dados entretenimento;

    private Dados mat_expediente;

    private Dados impostos;

    private Dados seguro;

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
        Descricao descricao;
        descricao = Descricao.SEG_LIMPEZA;
        if (seg_limpeza.getEscolha().equals(descricao)) {
            this.seg_limpeza = seg_limpeza;
        }
    }


    public Dados getSanepar() {
        return sanepar;
    }

    public void setSanepar(Dados sanepar) {
        Descricao descricao;
        descricao = Descricao.SANEPAR;
        if (sanepar.getEscolha().equals(descricao)) {
            this.sanepar = sanepar;
        }
    }

    public Dados getCopel() {
        return copel;
    }

    public void setCopel(Dados copel) {
        Descricao descricao;
        descricao = Descricao.COPEL;
        if (copel.getEscolha().equals(descricao)){
            this.copel = copel;
        }
    }

    public Dados getCont_praga() {
        return cont_praga;
    }

    public void setCont_praga(Dados cont_praga) {
        Descricao descricao;
        descricao = Descricao.CONT_PRAGA;
        if(cont_praga.getEscolha().equals(descricao)) {
            this.cont_praga = cont_praga;
        }
    }

    public Dados getEntretenimento() {
        return entretenimento;
    }

    public void setEntretenimento(Dados entretenimento) {
        Descricao descricao;
        descricao = Descricao.ENTRETENIMENTO;
        if (entretenimento.getEscolha().equals(descricao)) {
            this.entretenimento = entretenimento;
        }
    }

    public Dados getMat_expediente() {
        return mat_expediente;
    }

    public void setMat_expediente(Dados mat_expediente) {
        Descricao descricao;
        descricao = Descricao.MAT_EXPEDIENTE;
        if (mat_expediente.getEscolha().equals(descricao)){
            this.mat_expediente = mat_expediente;
        }
    }

    public Dados getImpostos() {
        return impostos;
    }

    public void setImpostos(Dados impostos) {
        Descricao descricao;
        descricao = Descricao.IMPOSTOS;
        if (impostos.getEscolha().equals(descricao)) {
            this.impostos = impostos;
        }
    }

    public Dados getSeguro() {
        return seguro;
    }

    public void setSeguro(Dados seguro) {
        Descricao descricao;
        descricao = Descricao.SEGURO;
        if (seguro.getEscolha().equals(descricao)) {
            this.seguro = seguro;
        }
    }

    public Dados getMat_Limpeza () {
        return mat_limpeza;
    }

    public void setMat_Limpeza(Dados mat_limpeza) {
        Descricao descricao;
        descricao = Descricao.MAT_LIMPEZA;
        if (mat_limpeza.getEscolha().equals(descricao)) {
            this.mat_limpeza = mat_limpeza;
        }
    }

    public Dados getMarketing () {
        return marketing;
    }

    public void setMarketing(Dados marketing) {
        Descricao descricao;
        descricao = Descricao.MARKETING;
        if (marketing.getEscolha().equals(descricao)) {
            this.marketing = marketing;
        }
    }

    public Dados getHonorario() {
        return honorario;
    }

    public void setHonorario(Dados honorario) {
        Descricao descricao;
        descricao = Descricao.HONORARIOS;
        if (honorario.getEscolha().equals(descricao)) {
            this.honorario = honorario;
        }
    }

    public Dados getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(Dados coleta_lixo) {
        Descricao descricao;
        descricao = Descricao.COLETA_LIXO;
        if (coleta_lixo.getEscolha().equals(descricao)) {
            this.coleta_lixo= coleta_lixo;
        }
    }

    public Dados getInternet() {
        return internet;
    }

    public void setInternet(Dados internet) {
        Descricao descricao;
        descricao = Descricao.INTERNET;
        if (internet.getEscolha().equals(descricao)) {
            this.internet= internet;
        }
    }

    public Dados getManutencao() {
        return manutencao;
    }

    public void setManutencao(Dados manutencao) {
        Descricao descricao;
        descricao = Descricao.MANUTENÇÃO;
        if (manutencao.getEscolha().equals(descricao)) {
            this.manutencao = manutencao;
        }
    }

    public Dados getLocacao() {
        return locacao;
    }

    public void setLocacao(Dados locacao) {
        Descricao descricao;
        descricao = Descricao.MANUTENÇÃO;
        if (locacao.getEscolha().equals(descricao)) {
            this.locacao = locacao;
        }
    }



    public Double mostrar() {
        Double SEG_LIMPEZA = Somar(seg_limpeza);
        Double SANEPAR = Somar(sanepar);
        Double COPEL = Somar(copel);
        Double CONT_PRAGA = Somar(cont_praga);
        Double ENTRETENIMENTO = Somar(entretenimento);
        Double MAT_EXPEDIENTE = Somar(mat_expediente);
        Double IMPOSTOS = Somar(impostos);
        Double SEGURO = Somar(seguro);
        Double MAT_LIMPEZA = Somar(mat_limpeza);
        Double MARKETING = Somar(marketing);
        Double HONORARIO = Somar(honorario);
        Double COLETA_LIXO = Somar(coleta_lixo);
        Double INTERNET = Somar(internet);
        Double MANUTENCAO = Somar(manutencao);
        Double LOCACAO = Somar(locacao);
        Double total = SEG_LIMPEZA + SANEPAR + COPEL + CONT_PRAGA + ENTRETENIMENTO + MAT_EXPEDIENTE + IMPOSTOS + SEGURO + MAT_LIMPEZA + MARKETING + HONORARIO + COLETA_LIXO + INTERNET + MANUTENCAO + LOCACAO;
        return total;
    }


    public Double Somar(Dados dados){
        List<Valor> valores = dados.getValor();
        Double total = 0.0;
        for (Valor valor : valores) {
            total += valor.getCampo();
        }
        System.out.println(total);
        return total;
    }

}