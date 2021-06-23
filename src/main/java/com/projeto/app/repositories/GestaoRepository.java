package com.projeto.app.repositories;

import java.util.List;

import com.projeto.app.models.Gestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository	
public interface GestaoRepository extends JpaRepository<Gestao,Long> {
    @Query(value = "SELECT * FROM GESTAO WHERE TIPO = ?1", nativeQuery = true)
    List<Gestao> findAllBytipo(Long id);
}