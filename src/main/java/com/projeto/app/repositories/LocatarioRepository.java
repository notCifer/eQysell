package com.projeto.app.repositories;

import java.util.Optional;
import com.projeto.app.models.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    Optional<Locatario> findByCpf(Long cpf);
}