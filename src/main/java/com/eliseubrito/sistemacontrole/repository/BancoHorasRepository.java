package com.eliseubrito.sistemacontrole.repository;

import com.eliseubrito.sistemacontrole.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
}
