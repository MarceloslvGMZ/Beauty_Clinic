package com.clinica.api.model.cliente;

import java.util.UUID;

public record ClienteResponseDTO(UUID id, String nome, String telefone) {

    public ClienteResponseDTO(Cliente cliente){
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone()
        );
    }
}
