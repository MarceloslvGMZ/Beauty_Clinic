package com.clinica.api.service;

import com.clinica.api.model.agendamento.Agendamento;
import com.clinica.api.model.agendamento.AgendamentoRequestDTO;

import java.util.Date;

public class AgendamentoService {

    public Agendamento criarAgendamento(AgendamentoRequestDTO data) {
        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setStatus(data.status());
        novoAgendamento.setDate(new Date(data.date()));
        novoAgendamento.setServico(data.servico());
        novoAgendamento.setCliente(data.cliente());
        novoAgendamento.setProfissional(data.profissional());

        return novoAgendamento;
    }
}
