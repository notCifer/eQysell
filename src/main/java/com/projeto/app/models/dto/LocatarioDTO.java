package com.projeto.app.models.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.projeto.app.models.Locatario;

public class LocatarioDTO {

    private Long id ;
    private String nome;
    private String email;
    private Long telefone;

    /* ___________________________GETTERS and SETTERS___________________________ */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    /* ___________________________METODO toDTO___________________________ */

    public LocatarioDTO toDTO(Locatario locatario) {
        LocatarioDTO DTO = new LocatarioDTO();
        DTO.setId(locatario.getId());
        DTO.setNome(locatario.getNome());
        DTO.setEmail(locatario.getEmail());
        DTO.setTelefone(locatario.getTelefone());
        return DTO;
    }

    public List<LocatarioDTO> toDTO(List<Locatario> locatarios) {
        return locatarios.stream().map(locatario -> toDTO(locatario)).collect(Collectors.toList());
    }
}


   