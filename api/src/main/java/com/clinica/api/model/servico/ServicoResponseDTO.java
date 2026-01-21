package com.clinica.api.model.servico;

import java.util.UUID;

public record ServicoResponseDTO(
        UUID idServico,
        String nome,
        String descricao,
        Float valor,
        boolean ativo
){

    public ServicoResponseDTO(Servico servico) {
        this(
                servico.getId(),
                servico.getNome(),
                servico.getDescricao(),
                servico.getValor(),
                servico.isAtivo()
        );
    }
}
