package com.projeto.app.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelatorioBruto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Double seg_limpeza;
    private Double sanepar;
    private Double mat_limpeza;
    private Double copel;
    private Double marketing;
    private Double cont_praga;
    private Double honorario;
    private Double entreterimento;
    private Double coleta_lixo;
    private Double internet;
    private Double mat_expediente;
    private Double manutencao;
    private Double impostos;
    private Double locacao;
    private Double seguro;

    public RelatorioBruto() {
    }

    public RelatorioBruto(LocalDate data, Double seg_limpeza, Double sanepar, Double mat_limpeza, Double copel,
            Double marketing, Double cont_praga, Double honorario, Double entreterimento, Double coleta_lixo,
            Double internet, Double mat_expediente, Double manutencao, Double impostos, Double locacao, Double seguro) {
        this.data = data;
        this.seg_limpeza = seg_limpeza;
        this.sanepar = sanepar;
        this.mat_limpeza = mat_limpeza;
        this.copel = copel;
        this.marketing = marketing;
        this.cont_praga = cont_praga;
        this.honorario = honorario;
        this.entreterimento = entreterimento;
        this.coleta_lixo = coleta_lixo;
        this.internet = internet;
        this.mat_expediente = mat_expediente;
        this.manutencao = manutencao;
        this.impostos = impostos;
        this.locacao = locacao;
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return "RelatorioBruto [coleta_lixo=" + coleta_lixo + ", cont_praga=" + cont_praga + ", copel=" + copel
                + ", data=" + data + ", entreterimento=" + entreterimento + ", honorario=" + honorario + ", id=" + id
                + ", impostos=" + impostos + ", internet=" + internet + ", locacao=" + locacao + ", manutencao="
                + manutencao + ", marketing=" + marketing + ", mat_expediente=" + mat_expediente + ", mat_limpeza="
                + mat_limpeza + ", sanepar=" + sanepar + ", seg_limpeza=" + seg_limpeza + ", seguro=" + seguro + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coleta_lixo == null) ? 0 : coleta_lixo.hashCode());
        result = prime * result + ((cont_praga == null) ? 0 : cont_praga.hashCode());
        result = prime * result + ((copel == null) ? 0 : copel.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((entreterimento == null) ? 0 : entreterimento.hashCode());
        result = prime * result + ((honorario == null) ? 0 : honorario.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((impostos == null) ? 0 : impostos.hashCode());
        result = prime * result + ((internet == null) ? 0 : internet.hashCode());
        result = prime * result + ((locacao == null) ? 0 : locacao.hashCode());
        result = prime * result + ((manutencao == null) ? 0 : manutencao.hashCode());
        result = prime * result + ((marketing == null) ? 0 : marketing.hashCode());
        result = prime * result + ((mat_expediente == null) ? 0 : mat_expediente.hashCode());
        result = prime * result + ((mat_limpeza == null) ? 0 : mat_limpeza.hashCode());
        result = prime * result + ((sanepar == null) ? 0 : sanepar.hashCode());
        result = prime * result + ((seg_limpeza == null) ? 0 : seg_limpeza.hashCode());
        result = prime * result + ((seguro == null) ? 0 : seguro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RelatorioBruto other = (RelatorioBruto) obj;
        if (coleta_lixo == null) {
            if (other.coleta_lixo != null)
                return false;
        } else if (!coleta_lixo.equals(other.coleta_lixo))
            return false;
        if (cont_praga == null) {
            if (other.cont_praga != null)
                return false;
        } else if (!cont_praga.equals(other.cont_praga))
            return false;
        if (copel == null) {
            if (other.copel != null)
                return false;
        } else if (!copel.equals(other.copel))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (entreterimento == null) {
            if (other.entreterimento != null)
                return false;
        } else if (!entreterimento.equals(other.entreterimento))
            return false;
        if (honorario == null) {
            if (other.honorario != null)
                return false;
        } else if (!honorario.equals(other.honorario))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (impostos == null) {
            if (other.impostos != null)
                return false;
        } else if (!impostos.equals(other.impostos))
            return false;
        if (internet == null) {
            if (other.internet != null)
                return false;
        } else if (!internet.equals(other.internet))
            return false;
        if (locacao == null) {
            if (other.locacao != null)
                return false;
        } else if (!locacao.equals(other.locacao))
            return false;
        if (manutencao == null) {
            if (other.manutencao != null)
                return false;
        } else if (!manutencao.equals(other.manutencao))
            return false;
        if (marketing == null) {
            if (other.marketing != null)
                return false;
        } else if (!marketing.equals(other.marketing))
            return false;
        if (mat_expediente == null) {
            if (other.mat_expediente != null)
                return false;
        } else if (!mat_expediente.equals(other.mat_expediente))
            return false;
        if (mat_limpeza == null) {
            if (other.mat_limpeza != null)
                return false;
        } else if (!mat_limpeza.equals(other.mat_limpeza))
            return false;
        if (sanepar == null) {
            if (other.sanepar != null)
                return false;
        } else if (!sanepar.equals(other.sanepar))
            return false;
        if (seg_limpeza == null) {
            if (other.seg_limpeza != null)
                return false;
        } else if (!seg_limpeza.equals(other.seg_limpeza))
            return false;
        if (seguro == null) {
            if (other.seguro != null)
                return false;
        } else if (!seguro.equals(other.seguro))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getSeg_limpeza() {
        return seg_limpeza;
    }

    public void setSeg_limpeza(Double seg_limpeza) {
        this.seg_limpeza = seg_limpeza;
    }

    public Double getSanepar() {
        return sanepar;
    }

    public void setSanepar(Double sanepar) {
        this.sanepar = sanepar;
    }

    public Double getMat_limpeza() {
        return mat_limpeza;
    }

    public void setMat_limpeza(Double mat_limpeza) {
        this.mat_limpeza = mat_limpeza;
    }

    public Double getCopel() {
        return copel;
    }

    public void setCopel(Double copel) {
        this.copel = copel;
    }

    public Double getMarketing() {
        return marketing;
    }

    public void setMarketing(Double marketing) {
        this.marketing = marketing;
    }

    public Double getCont_praga() {
        return cont_praga;
    }

    public void setCont_praga(Double cont_praga) {
        this.cont_praga = cont_praga;
    }

    public Double getHonorario() {
        return honorario;
    }

    public void setHonorario(Double honorario) {
        this.honorario = honorario;
    }

    public Double getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(Double entreterimento) {
        this.entreterimento = entreterimento;
    }

    public Double getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(Double coleta_lixo) {
        this.coleta_lixo = coleta_lixo;
    }

    public Double getInternet() {
        return internet;
    }

    public void setInternet(Double internet) {
        this.internet = internet;
    }

    public Double getMat_expediente() {
        return mat_expediente;
    }

    public void setMat_expediente(Double mat_expediente) {
        this.mat_expediente = mat_expediente;
    }

    public Double getManutencao() {
        return manutencao;
    }

    public void setManutencao(Double manutencao) {
        this.manutencao = manutencao;
    }

    public Double getImpostos() {
        return impostos;
    }

    public void setImpostos(Double impostos) {
        this.impostos = impostos;
    }

    public Double getLocacao() {
        return locacao;
    }

    public void setLocacao(Double locacao) {
        this.locacao = locacao;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

}