package com.clinica.api.service;

import com.clinica.api.model.agendamento.Agendamento;
import com.clinica.api.model.agendamento.AgendamentoRequestDTO;
import com.clinica.api.model.agendamento.AgendamentoResponseDTO;
import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.profissional.ProfissionalResponseDTO;
import com.clinica.api.model.servico.Servico;
import com.clinica.api.repository.AgendamentoRepository;
import com.clinica.api.repository.ClienteRepository;
import com.clinica.api.repository.ProfissionalRepository;
import com.clinica.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Agendamento criarAgendamento(AgendamentoRequestDTO data) {

        Servico servico = servicoRepository.findById(data.servicoId())
                .orElseThrow(() -> new RuntimeException("Servico nao encontrado"));

        Cliente cliente = clienteRepository.findById(data.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));

        Profissional profissional = profissionalRepository.findById(data.profissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional nao encontrado"));


        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setStatus(data.status());
        novoAgendamento.setDate(new Date(data.date()));
        novoAgendamento.setServico(servico);
        novoAgendamento.setCliente(cliente);
        novoAgendamento.setProfissional(profissional);

        repository.save(novoAgendamento);

        return novoAgendamento;
    }

    public List<AgendamentoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }
}
