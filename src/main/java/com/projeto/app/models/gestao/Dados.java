package com.projeto.app.models.gestao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Dados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TipoEnum escolha; 
    @OneToMany
    @JoinColumn(name = "dados_id")
    private List<Valor> valor;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public TipoEnum getEscolha() {
        return escolha;
    }
    public void setEscolha(TipoEnum escolha) {
        this.escolha = escolha;
    }
    public List<Valor> getValor() {
        return valor;
    }
    public void setValor(List<Valor> valor) {
        this.valor = valor;
    }
  
}