package com.clinica.api.model.agendamento;

import java.util.List;
import java.util.UUID;

public record AgendamentoRequestDTO(String status, Long date, List<UUID> servicoIds, UUID clienteId, UUID profissionalId) {
}
