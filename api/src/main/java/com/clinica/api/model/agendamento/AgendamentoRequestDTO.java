package com.clinica.api.model.agendamento;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.servico.Servico;

public record AgendamentoRequestDTO(String status, Long date, Servico servico, Cliente cliente, Profissional profissional) {
}
