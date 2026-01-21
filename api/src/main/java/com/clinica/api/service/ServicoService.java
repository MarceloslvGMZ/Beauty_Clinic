package com.clinica.api.service;

import com.clinica.api.model.servico.Servico;
import com.clinica.api.model.servico.ServicoRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    public Servico criarServico(ServicoRequestDTO data) {
        Servico novoServico = new Servico();
        novoServico.setNome(data.nome());
        novoServico.setDescricao(data.descricao());
        novoServico.setValor(data.valor());
        novoServico.setAtivo(data.ativo());

        return novoServico;

    }
}
