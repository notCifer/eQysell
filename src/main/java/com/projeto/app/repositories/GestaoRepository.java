package com.projeto.app.repositories;

import java.util.List;
import java.util.Optional;

import com.projeto.app.models.Gestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository	
public interface GestaoRepository extends JpaRepository<Gestao,Long> {
    @Query(value = "SELECT * FROM GESTAO WHERE TIPO = ?1 AND MONTH(DATA_CREATE) = ?2", nativeQuery = true)
    List<Gestao> findAllBy(int tipo, Long mes);

    Optional<Gestao> findByDescricao(String descricao);
}