package com.projeto.app.models.form;

import java.util.List;

import com.projeto.app.models.gestao.Dados;
import com.projeto.app.models.gestao.Descricao;
import com.projeto.app.models.gestao.Valor;

public class FinanceiroFORM {

    private Dados seg_limpeza;
    // @NotNull
    private Dados sanepar;
    // @NotNull
    // private Double mat_limpeza;
    // @NotNull
    private Dados copel;
    // @NotNull
    // private Double marketing;
    // @NotNull
    private Dados cont_praga;
    // @NotNull
    // private Double honorario;
    // @NotNull
    private Dados entretenimento;
    // @NotNull
    // private Double coleta_lixo;
    // @NotNull
    // private Double internet;
    // @NotNull
    private Dados mat_expediente;
    // @NotNull
    // private Double manutencao;
    // @NotNull
    private Dados impostos;
    // @NotNull
    // private Double locacao;
    // @NotNull
    private Dados seguro;

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

    public Double mostrar() {
        Double SEG_LIMPEZA = Somar(seg_limpeza);
        Double SANEPAR = Somar(sanepar);
        Double COPEL = Somar(copel);
        Double CONT_PRAGA = Somar(cont_praga);
        Double ENTRETENIMENTO = Somar(entretenimento);
        Double MAT_EXPEDIENTE = Somar(mat_expediente);
        Double IMPOSTOS = Somar(impostos);
        Double SEGURO = Somar(seguro);
        Double total = SEG_LIMPEZA + SANEPAR + COPEL + CONT_PRAGA + ENTRETENIMENTO + MAT_EXPEDIENTE + IMPOSTOS + SEGURO;
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