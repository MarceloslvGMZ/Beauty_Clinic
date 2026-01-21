package com.clinica.api.controller;



import com.clinica.api.model.servico.Servico;
import com.clinica.api.model.servico.ServicoRequestDTO;
import com.clinica.api.model.servico.ServicoResponseDTO;
import com.clinica.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody ServicoRequestDTO body) {
        Servico newServico = this.servicoService.criarServico(body);

        return ResponseEntity.ok(newServico);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> findAll(){
        return ResponseEntity.ok(this.servicoService.findAll());
    }

}
