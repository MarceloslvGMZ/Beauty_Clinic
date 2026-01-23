package com.clinica.api.repository;

import com.clinica.api.model.galeria.GaleriaPortfolio;
import com.clinica.api.model.galeria.GaleriaResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GaleriaRepository extends JpaRepository<GaleriaPortfolio, UUID> {
    List<GaleriaPortfolio> findByServicoId(UUID servicoId);
}
