package com.projeto.app.models.gestao;

public enum TipoEnum {

    SEG_LIMPEZA(1L,"Segurança Limpeza"), SANEPAR (2L,"Sanepar"), MAT_LIMPEZA (3L,"Material de Limpeza"), MARKETING (4L,"Marketing"), CONT_PRAGA (5L,"Contenção de Pragas"), HONORARIOS(6L,"Honorarios"), ENTRETERIMENTO(7L,"Entreterimento"), COLETA_LIXO(8L,"Coleta de Lixo"), INTERNET(9L,"Internet"),
    MAT_EXPEDIENTE(10L,"Material de Expediente"), MANUTENÇÃO(11L,"Manutenção"), IMPOSTOS(12L,"Impostos"), LOCAÇÕES(13L,"Locação"), SEGURO(14L,"Seguro"), COPEL(15L,"Copel"), SANEPAR_PRIVATIVA(16L,"Sanepar Privativa");

    private Long id;
    private String name;

    private TipoEnum(Long id, String name) {
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