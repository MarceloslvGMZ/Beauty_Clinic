package com.clinica.api.controller;

import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.profissional.ProfissionalRequestDTO;
import com.clinica.api.model.profissional.ProfissionalResponseDTO;
import com.clinica.api.service.ProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional")
@RequiredArgsConstructor
public class ProfissionalController {


    private final ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> criarProfissional(@RequestBody ProfissionalRequestDTO body) {
        ProfissionalResponseDTO profissional = this.profissionalService.criarProfissional(body);

        return ResponseEntity.ok(profissional);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> findAll(){
        return ResponseEntity.ok(this.profissionalService.findAll());
    }
}
