package com.projeto.app.repositories;

import com.projeto.app.models.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository  extends JpaRepository<Localizacao, Long> {
}
