package com.projeto.app.repositories;

import com.projeto.app.models.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocalizacaoRepository  extends JpaRepository<Localizacao, Long> {

    @Query(value = "SELECT * FROM LOCALIZACAO WHERE LOCAL = ?1" , nativeQuery = true)
    Localizacao findByTipo(Long idLocalizacao);
}
