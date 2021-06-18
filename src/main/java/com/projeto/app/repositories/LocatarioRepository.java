package com.projeto.app.repositories;

import com.projeto.app.models.Locatario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository <Locatario, Long> {
    
}