package com.eliseubrito.sistemacontrole.repository;

import com.eliseubrito.sistemacontrole.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
}
