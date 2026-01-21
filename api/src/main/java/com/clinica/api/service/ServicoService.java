package com.clinica.api.service;

import com.clinica.api.model.servico.Servico;
import com.clinica.api.model.servico.ServicoRequestDTO;
import com.clinica.api.model.servico.ServicoResponseDTO;
import com.clinica.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico criarServico(ServicoRequestDTO data) {
        Servico novoServico = new Servico();
        novoServico.setNome(data.nome());
        novoServico.setDescricao(data.descricao());
        novoServico.setValor(data.valor());
        novoServico.setAtivo(data.ativo());

        repository.save(novoServico);

        return novoServico;
    }

    public List<ServicoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ServicoResponseDTO::new)
                .toList();
    }

}
