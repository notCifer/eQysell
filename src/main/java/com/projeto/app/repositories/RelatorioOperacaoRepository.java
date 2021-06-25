package com.projeto.app.repositories;

import java.util.List;

import com.projeto.app.models.RelatorioOperacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioOperacaoRepository extends JpaRepository<RelatorioOperacao, Long> {

    @Query(value = "SELECT * FROM RELATORIO_OPERACAO WHERE MONTH(DATA) = ?1", nativeQuery = true)
    List<RelatorioOperacao> findAllByMes(Long mes);
}