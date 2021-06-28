package com.projeto.app.repositories;

import com.projeto.app.models.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PisoRepository extends JpaRepository <Piso, Long> {

    @Query(value = "SELECT * FROM PISO WHERE PISO = ?1" , nativeQuery = true)
    Piso findByTipo(Long idPiso);
}