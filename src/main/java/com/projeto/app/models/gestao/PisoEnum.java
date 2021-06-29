package com.projeto.app.models.gestao;

public enum PisoEnum {

    MARECHAL_DEODORO(1L, "Marechal Deodoro"), DECK(2L, "Deck"), JOSE_LOUREIRO(3L, "José Loureiro");

    private Long id;
    private String name;

    private PisoEnum(Long id, String name) {
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