package com.eliseubrito.sistemacontrole.repository;

import com.eliseubrito.sistemacontrole.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {
}
