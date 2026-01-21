package com.clinica.api.controller;

import com.clinica.api.model.agendamento.Agendamento;
import com.clinica.api.model.agendamento.AgendamentoRequestDTO;
import com.clinica.api.model.agendamento.AgendamentoResponseDTO;
import com.clinica.api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody AgendamentoRequestDTO body){
        Agendamento newAgendamento = this.agendamentoService.criarAgendamento(body);


        return ResponseEntity.ok(newAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> findAll(){
        return ResponseEntity.ok(agendamentoService.findAll());
    }
}
