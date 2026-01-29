package com.clinica.api.service;

import com.clinica.api.model.servico.Servico;
import com.clinica.api.model.servico.ServicoRequestDTO;
import com.clinica.api.model.servico.ServicoResponseDTO;
import com.clinica.api.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoResponseDTO criarServico(ServicoRequestDTO data) {
        Servico novoServico = new Servico();
        novoServico.setNome(data.nome());
        novoServico.setDescricao(data.descricao());
        novoServico.setValor(data.valor());
        novoServico.setAtivo(data.ativo());

        Servico servicoSalvo = repository.save(novoServico);

        return new ServicoResponseDTO(servicoSalvo);
    }

    public List<ServicoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ServicoResponseDTO::new)
                .toList();
    }

}
