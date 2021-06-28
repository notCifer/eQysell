package com.projeto.app.repositories;

import com.projeto.app.models.Abl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AblRepository extends JpaRepository<Abl,Long> {
    
}