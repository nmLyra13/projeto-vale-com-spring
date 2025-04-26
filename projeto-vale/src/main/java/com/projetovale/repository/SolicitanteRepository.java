package com.projetovale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetovale.model.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
}
