package com.clinica.api.model.profissional;

import java.util.UUID;

public record ProfissionalResponseDTO(UUID id, String nome) {

    public ProfissionalResponseDTO(Profissional profissional){
        this(
                profissional.getId(),
                profissional.getNome()
        );
    }
}
