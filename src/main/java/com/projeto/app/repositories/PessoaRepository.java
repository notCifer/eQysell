package com.projeto.app.repositories;

import java.util.Optional;

import com.projeto.app.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
    Optional<Pessoa> findByCpf(Long cpf);
}