package com.clinica.api.controller;

import com.clinica.api.model.galeria.GaleriaPortfolio;
import com.clinica.api.model.galeria.GaleriaRequestDTO;
import com.clinica.api.model.servico.Servico;
import com.clinica.api.service.GaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/servico/portfolio")
public class GaleriaController {

    @Autowired
    private GaleriaService galeriaService;

    @PostMapping(path = "/servico/{servicoId}", consumes = "multipart/form-data")
    public ResponseEntity<GaleriaPortfolio> criarPortfolio(
            @PathVariable UUID servicoId,
            @RequestParam ("image") MultipartFile image
    ){
        GaleriaRequestDTO galeriaRequestDTO = new GaleriaRequestDTO(image, servicoId);
        GaleriaPortfolio galeria = this.galeriaService.criarPortfolio(galeriaRequestDTO);

        return ResponseEntity.ok(galeria);
    }
}
