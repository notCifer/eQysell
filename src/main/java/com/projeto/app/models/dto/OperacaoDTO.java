package com.projeto.app.models.dto;

import com.projeto.app.models.Operacao;
import java.util.stream.Collectors;
import java.util.List;

public class OperacaoDTO {

    private String nome;
    private String razaosocial;
    private long cnpj;

    /* ___________________________GETTERS and SETTERS___________________________ */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    /* ___________________________METODO toDTO___________________________ */

    public static OperacaoDTO toDTO(Operacao op) {
        OperacaoDTO dto = new OperacaoDTO();
        dto.setNome(op.getNome());
        dto.setRazaosocial(op.getRazaosocial());
        dto.setCnpj(op.getCnpj());
        return dto;
    }

    public static List<OperacaoDTO> toDTO(List<Operacao> op) {
        return op.stream().map(x -> toDTO(x)).collect(Collectors.toList());
    }
}
