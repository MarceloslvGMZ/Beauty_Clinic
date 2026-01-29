package com.clinica.api.service;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.cliente.ClienteRequestDTO;
import com.clinica.api.model.cliente.ClienteResponseDTO;
import com.clinica.api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepository repository;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO data) {
        Cliente newCliente = new Cliente();
        newCliente.setNome(data.nome());
        newCliente.setTelefone(data.telefone());

        Cliente clienteSalvo = repository.save(newCliente);

        return new ClienteResponseDTO(clienteSalvo);
    }

    public List<ClienteResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ClienteResponseDTO::new)
                .toList();
    }
}
