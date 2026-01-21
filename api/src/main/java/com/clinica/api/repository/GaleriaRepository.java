package com.clinica.api.repository;

import com.clinica.api.model.galeria.GaleriaPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GaleriaRepository extends JpaRepository<GaleriaPortfolio, UUID> {
}
