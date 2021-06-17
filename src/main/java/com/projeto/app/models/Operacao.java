package com.projeto.app.models;
//###############################################################################//
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//###############################################################################//

public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Notlank
    private String nome;
    private String razaosocial;
    @NotNull
    @NotNull @NotEmpty
    private Locatario response;
    private long cnpj;

    //###############################################################################//

    public Operacao() {
    }

    //###############################################################################//

    public Operacao(String nome, String razaosocial, Locatario response, long cnpj) {
        this.nome = nome;
        this.razaosocial = razaosocial;
        this.response = response;
        this.cnpj = cnpj;
    }

    //###############################################################################//


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

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public Locatario getResponse() {
        return response;
    }

    public void setResponse(Locatario response) {
        this.response = response;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    //###############################################################################//


}
