package com.projeto.app.repositories;

import com.projeto.app.models.Abl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AblRepository extends JpaRepository<Abl,Long> {
    
    @Query(value = "SELECT * FROM ABL WHERE VALOR between ?1 AND ?2",nativeQuery = true)
    Abl findByValor(Double valor2,Double valor);
}