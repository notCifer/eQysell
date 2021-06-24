package com.projeto.app.services;

import java.util.List;
import com.projeto.app.models.Gestao;
import org.springframework.stereotype.Service;

@Service
public class Calcular {

    public Double calcularPeloTipo(List<Gestao> dados) {
        Double total = 0.0;
        for (Gestao gestao : dados) {
            total += gestao.getValor();
        }
        return total;
    }

}