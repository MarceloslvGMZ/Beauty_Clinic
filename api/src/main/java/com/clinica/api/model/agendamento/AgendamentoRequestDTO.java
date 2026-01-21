package com.clinica.api.model.agendamento;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.servico.Servico;

import java.util.UUID;

public record AgendamentoRequestDTO(String status, Long date, UUID servicoId, UUID clienteId, UUID profissionalId) {
}
