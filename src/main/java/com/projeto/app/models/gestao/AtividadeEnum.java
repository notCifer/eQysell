package com.projeto.app.models.gestao;

public enum AtividadeEnum {

    ALIMENTACAO(1L, "Alimentação"), OUTROS(2L, "Outros"), QUIOSQUE(3L, "Quiosque");

    private Long id;
    private String name;

    private AtividadeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}