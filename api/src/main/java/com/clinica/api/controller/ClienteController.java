package com.clinica.api.controller;

import com.clinica.api.model.cliente.Cliente;
import com.clinica.api.model.cliente.ClienteRequestDTO;
import com.clinica.api.model.cliente.ClienteResponseDTO;
import com.clinica.api.service.ClienteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    private ResponseEntity<Cliente> criarCliente(@RequestBody ClienteRequestDTO body) {
        Cliente newCliente = this.clienteService.criarCliente(body);

        return ResponseEntity.ok(newCliente);
    }

    @GetMapping
    private ResponseEntity<List<ClienteResponseDTO>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
