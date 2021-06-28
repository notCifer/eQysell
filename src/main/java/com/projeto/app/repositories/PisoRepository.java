package com.projeto.app.repositories;

import com.projeto.app.models.Piso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PisoRepository extends JpaRepository <Piso, Long> {
    
}