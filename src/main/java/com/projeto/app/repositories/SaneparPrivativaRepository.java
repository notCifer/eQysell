package com.projeto.app.repositories;

import com.projeto.app.models.SaneparPrivativa;
import com.projeto.app.models.gestao.TipoEnum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaneparPrivativaRepository extends JpaRepository <SaneparPrivativa, TipoEnum> {
    
}