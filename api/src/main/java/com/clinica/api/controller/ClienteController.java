package com.clinica.api.controller;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.cliente.ClienteRequestDTO;
import com.clinica.api.model.cliente.ClienteResponseDTO;
import com.clinica.api.service.ClienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {


    private final ClienteService clienteService;

    @PostMapping
    private ResponseEntity<ClienteResponseDTO> criarCliente(@RequestBody ClienteRequestDTO body) {
        ClienteResponseDTO newCliente = this.clienteService.criarCliente(body);

        return ResponseEntity.ok(newCliente);
    }

    @GetMapping
    private ResponseEntity<List<ClienteResponseDTO>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
