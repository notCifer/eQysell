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
    // private Double copel;
    // @NotNull
    // private Double marketing;
    // @NotNull
    // private Double cont_praga;
    // @NotNull
    // private Double honorario;
    // @NotNull
    // private Double entreterimento;
    // @NotNull
    // private Double coleta_lixo;
    // @NotNull
    // private Double internet;
    // @NotNull
    // private Double mat_expidiente;
    // @NotNull
    // private Double manutencao;
    // @NotNull
    // private Double impostos;
    // @NotNull
    // private Double locacao;
    // @NotNull
    // private Double seguro;

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

    public Double mostrar() {
        Double SEG_LIMPEZA = Somar(seg_limpeza);
        Double SANEPAR = Somar(sanepar);
        Double total = SEG_LIMPEZA + SANEPAR;
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