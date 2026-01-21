package com.clinica.api.model.galeria;

import com.clinica.api.model.servico.Servico;

import java.util.UUID;

public record GaleriaResponseDTO(UUID id, String imgUrl, Servico servico) {

    public GaleriaResponseDTO(GaleriaPortfolio galeria){
        this(
                galeria.getId(),
                galeria.getImgUrl(),
                galeria.getServico()
        );
    }
}
