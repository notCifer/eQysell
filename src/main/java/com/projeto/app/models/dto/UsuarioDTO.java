package com.projeto.app.models.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.projeto.app.models.Usuario;

public class UsuarioDTO {

    private Long id;
    private String email;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO DTO = new UsuarioDTO();
        DTO.setId(usuario.getId());
        DTO.setEmail(usuario.getEmail());
        return DTO;
    }

    public List<UsuarioDTO> toDTO(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> toDTO(usuario)).collect(Collectors.toList());
    }

}