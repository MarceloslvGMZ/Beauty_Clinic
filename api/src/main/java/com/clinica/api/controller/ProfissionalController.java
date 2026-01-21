package com.clinica.api.controller;

import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.profissional.ProfissionalRequestDTO;
import com.clinica.api.model.profissional.ProfissionalResponseDTO;
import com.clinica.api.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<Profissional> criarProfissional(@RequestBody ProfissionalRequestDTO body) {
        Profissional profissional = this.profissionalService.criarProfissional(body);

        return ResponseEntity.ok(profissional);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> findAll(){
        return ResponseEntity.ok(this.profissionalService.findAll());
    }
}
