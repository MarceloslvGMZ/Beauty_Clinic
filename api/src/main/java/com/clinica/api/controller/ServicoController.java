package com.clinica.api.controller;



import com.clinica.api.model.servico.Servico;
import com.clinica.api.model.servico.ServicoRequestDTO;
import com.clinica.api.model.servico.ServicoResponseDTO;
import com.clinica.api.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criarServico(@RequestBody ServicoRequestDTO body) {
        ServicoResponseDTO newServico = this.servicoService.criarServico(body);

        return ResponseEntity.ok(newServico);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> findAll(){
        return ResponseEntity.ok(this.servicoService.findAll());
    }

}
