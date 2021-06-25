package com.projeto.app.repositories;

import com.projeto.app.models.RelatorioBruto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioBrutoRepository extends JpaRepository<RelatorioBruto, Long> {
    @Query(value = "SELECT * FROM RELATORIO_BRUTO WHERE MONTH(DATA)=?1", nativeQuery = true)
    RelatorioBruto findByMes(Long mes);
}