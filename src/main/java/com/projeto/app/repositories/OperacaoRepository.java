package com.projeto.app.repositories;

import java.util.Optional;
import com.projeto.app.models.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Optional<Operacao> findByNome(String nome);
}
