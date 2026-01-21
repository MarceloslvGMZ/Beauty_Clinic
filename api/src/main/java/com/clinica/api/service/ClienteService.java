package com.clinica.api.service;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.cliente.ClienteRequestDTO;
import com.clinica.api.model.cliente.ClienteResponseDTO;
import com.clinica.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente criarCliente(ClienteRequestDTO data) {
        Cliente newCliente = new Cliente();
        newCliente.setNome(data.nome());
        newCliente.setTelefone(data.telefone());

        repository.save(newCliente);

        return newCliente;
    }

    public List<ClienteResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ClienteResponseDTO::new)
                .toList();
    }
}
