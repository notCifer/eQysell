package com.projeto.app.models.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.projeto.app.models.Financeiro;

public class FinanceiroDTO {

    private List<Double> seg_limpeza;
    private List<Double> sanepar;
    private List<Double> mat_limpeza;
    private List<Double> copel;
    private List<Double> marketing;
    private List<Double> cont_praga;
    private List<Double> honorario;
    private List<Double> entreterimento;
    private List<Double> coleta_lixo;
    private List<Double> internet;
    private List<Double> mat_expidiente;
    private List<Double> manutencao;
    private List<Double> impostos;
    private List<Double> locacao;
    private List<Double> seguro;

    public List<Double> getSeg_limpeza() {
        return seg_limpeza;
    }

    public void setSeg_limpeza(List<Double> seg_limpeza) {
        this.seg_limpeza = seg_limpeza;
    }

    public List<Double> getSanepar() {
        return sanepar;
    }

    public void setSanepar(List<Double> sanepar) {
        this.sanepar = sanepar;
    }

    public List<Double> getMat_limpeza() {
        return mat_limpeza;
    }

    public void setMat_limpeza(List<Double> mat_limpeza) {
        this.mat_limpeza = mat_limpeza;
    }

    public List<Double> getCopel() {
        return copel;
    }

    public void setCopel(List<Double> copel) {
        this.copel = copel;
    }

    public List<Double> getMarketing() {
        return marketing;
    }

    public void setMarketing(List<Double> marketing) {
        this.marketing = marketing;
    }

    public List<Double> getCont_praga() {
        return cont_praga;
    }

    public void setCont_praga(List<Double> cont_praga) {
        this.cont_praga = cont_praga;
    }

    public List<Double> getHonorario() {
        return honorario;
    }

    public void setHonorario(List<Double> honorario) {
        this.honorario = honorario;
    }

    public List<Double> getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(List<Double> entreterimento) {
        this.entreterimento = entreterimento;
    }

    public List<Double> getColeta_lixo() {
        return coleta_lixo;
    }

    public void setColeta_lixo(List<Double> coleta_lixo) {
        this.coleta_lixo = coleta_lixo;
    }

    public List<Double> getInternet() {
        return internet;
    }

    public void setInternet(List<Double> internet) {
        this.internet = internet;
    }

    public List<Double> getMat_expidiente() {
        return mat_expidiente;
    }

    public void setMat_expidiente(List<Double> mat_expidiente) {
        this.mat_expidiente = mat_expidiente;
    }

    public List<Double> getManutencao() {
        return manutencao;
    }

    public void setManutencao(List<Double> manutencao) {
        this.manutencao = manutencao;
    }

    public List<Double> getImpostos() {
        return impostos;
    }

    public void setImpostos(List<Double> impostos) {
        this.impostos = impostos;
    }

    public List<Double> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Double> locacao) {
        this.locacao = locacao;
    }

    public List<Double> getSeguro() {
        return seguro;
    }

    public void setSeguro(List<Double> seguro) {
        this.seguro = seguro;
    }

    public FinanceiroDTO toDTO(Financeiro financeiro) {
        FinanceiroDTO DTO = new FinanceiroDTO();
        DTO.setSeg_limpeza(financeiro.getSeglimpeza());
        DTO.setSanepar(financeiro.getSanepar());
        DTO.setMat_limpeza(financeiro.getMatlimpeza());
        DTO.setCopel(financeiro.getCopel());
        DTO.setMarketing(financeiro.getMarketing());
        DTO.setCont_praga(financeiro.getContpraga());
        DTO.setHonorario(financeiro.getHonorario());
        DTO.setEntreterimento(financeiro.getEntreterimento());
        DTO.setColeta_lixo(financeiro.getColeta());
        DTO.setInternet(financeiro.getInternet());
        DTO.setMat_expidiente(financeiro.getMatexpidiente());
        DTO.setManutencao(financeiro.getManutencao());
        DTO.setImpostos(financeiro.getImpostos());
        DTO.setLocacao(financeiro.getLocacao());
        DTO.setSeguro(financeiro.getSeguro());
        return DTO;
    }

    public List<FinanceiroDTO> toDTO(List<Financeiro> financeiros) {
        return financeiros.stream().map(financeiro -> toDTO(financeiro)).collect(Collectors.toList());
    }
}