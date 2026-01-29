package com.clinica.api.service;

import com.clinica.api.model.agendamento.Agendamento;
import com.clinica.api.model.agendamento.AgendamentoRequestDTO;
import com.clinica.api.model.agendamento.AgendamentoResponseDTO;
import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.servico.Servico;
import com.clinica.api.repository.AgendamentoRepository;
import com.clinica.api.repository.ClienteRepository;
import com.clinica.api.repository.ProfissionalRepository;
import com.clinica.api.repository.ServicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {


    private final AgendamentoRepository repository;
    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;

    @Transactional
    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO data) {

        List<Servico> servicos = servicoRepository.findAllById(data.servicoIds());
        if(servicos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pelo menos um serviço deve ser selecionado.");
        }

        Cliente cliente = clienteRepository.findById(data.clienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

        Profissional profissional = profissionalRepository.findById(data.profissionalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado."));


        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setStatus(data.status());
        novoAgendamento.setDate(new Date(data.date()));
        novoAgendamento.setServicos(servicos);
        novoAgendamento.setCliente(cliente);
        novoAgendamento.setProfissional(profissional);

        Agendamento agendamentoSalvo = repository.save(novoAgendamento);

        return new AgendamentoResponseDTO(agendamentoSalvo);
    }

    public List<AgendamentoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> findByClienteName(String name){
        return repository.findByClienteName(name)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> findByServico(String servico){
        return repository.findByServico(servico)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> findByStatus(String status){
        return repository.findByStatus(status)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> findUpcoming(Date data){
        return repository.findUpcoming(data)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> findBetweenDates(Date inicio, Date fim){
        return repository.findBetweenDates(inicio, fim)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public Double somarFaturamentoDoPeriodo(Date inicio, Date fim){
        Double faturamento = repository.somarFaturamentoDoPeriodo(inicio, fim);
        return faturamento != null ? faturamento : 0.0;
    }

    @Transactional
    public AgendamentoResponseDTO alterarStatus(UUID id, String novoStatus) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
        if(novoStatus != null && !novoStatus.isBlank()) {
            agendamento.setStatus(novoStatus);
        }

        repository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);

    }
}
