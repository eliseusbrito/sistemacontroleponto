package com.eliseubrito.sistemacontrole.repository;

import com.eliseubrito.sistemacontrole.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
