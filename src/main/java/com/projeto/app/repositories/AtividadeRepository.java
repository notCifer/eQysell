package com.projeto.app.repositories;

import com.projeto.app.models.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade,Long> {

    @Query(value = "SELECT * FROM ATIVIDADE WHERE ATIVIDADE = ?1 ", nativeQuery = true)
    Atividade findByTipo(Long atividade);
    
}