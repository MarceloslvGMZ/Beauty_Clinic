package com.clinica.api.model.agendamento;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.servico.ServicoResponseDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AgendamentoResponseDTO(UUID id, Date data, String status, List<ServicoResponseDTO> servicos, Cliente cliente, Profissional profissional) {

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this(
                agendamento.getId(),
                agendamento.getDate(),
                agendamento.getStatus(),
                agendamento.getServicos().stream()
                        .map(ServicoResponseDTO::new)
                        .toList(),
                agendamento.getCliente(),
                agendamento.getProfissional()
        );

    }
}
