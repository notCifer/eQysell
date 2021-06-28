package com.projeto.app.models.gestao;

public enum LocalizacaoEnum {
    A(1L, "A"), B(2L, "B");

    private Long id;
    private String name;

    private LocalizacaoEnum(Long id, String name) {
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
