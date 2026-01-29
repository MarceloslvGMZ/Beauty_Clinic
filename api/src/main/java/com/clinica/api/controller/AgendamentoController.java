package com.clinica.api.controller;

import com.clinica.api.model.agendamento.AgendamentoRequestDTO;
import com.clinica.api.model.agendamento.AgendamentoResponseDTO;
import com.clinica.api.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody AgendamentoRequestDTO body){
        AgendamentoResponseDTO newAgendamento = this.agendamentoService.criarAgendamento(body);
        return ResponseEntity.ok(newAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> findAll(){
        return ResponseEntity.ok(agendamentoService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AgendamentoResponseDTO>> search(
            @RequestParam(required = false) String cliente,
            @RequestParam(required = false) String servico,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim

    ){
        if (cliente != null ) return ResponseEntity.ok(agendamentoService.findByClienteName(cliente));
        if (servico != null) return ResponseEntity.ok(agendamentoService.findByServico(servico));
        if (status != null) return ResponseEntity.ok(agendamentoService.findByStatus(status));
        if (inicio != null && fim != null) return ResponseEntity.ok(agendamentoService.findBetweenDates(inicio, fim));
        if (inicio != null) return ResponseEntity.ok(agendamentoService.findUpcoming(inicio));

        return ResponseEntity.ok(agendamentoService.findAll());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AgendamentoResponseDTO> atualizarStatus(
            @PathVariable UUID id,
            @RequestParam String novoStatus){
        return ResponseEntity.ok(agendamentoService.alterarStatus(id, novoStatus));
    }

    @GetMapping("/relatorio/faturamento")
    public ResponseEntity<Double> getFaturamento(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim
            ){
        return ResponseEntity.ok(agendamentoService.somarFaturamentoDoPeriodo(inicio, fim));
    }
}
