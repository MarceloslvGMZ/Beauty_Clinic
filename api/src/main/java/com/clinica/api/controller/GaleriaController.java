package com.clinica.api.controller;

import com.clinica.api.model.galeria.GaleriaPortfolio;
import com.clinica.api.model.galeria.GaleriaRequestDTO;
import com.clinica.api.model.galeria.GaleriaResponseDTO;
import com.clinica.api.service.GaleriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class GaleriaController {


    private final GaleriaService galeriaService;

    @PostMapping(path = "/servico/{servicoId}", consumes = "multipart/form-data")
    public ResponseEntity<GaleriaResponseDTO> criarPortfolio(
            @PathVariable UUID servicoId,
            @RequestParam ("image") MultipartFile image
    ){
        GaleriaRequestDTO galeriaRequestDTO = new GaleriaRequestDTO(image, servicoId);
        GaleriaResponseDTO galeria = this.galeriaService.criarPortfolio(galeriaRequestDTO);

        return ResponseEntity.ok(galeria);
    }

    @GetMapping(path = "/servico/{servicoId}")
    public ResponseEntity<List<GaleriaResponseDTO>> listarPortfolioPorServico(
            @PathVariable UUID servicoId
    ){
        List<GaleriaResponseDTO> galeria = this.galeriaService.listarPortfolioPorServico(servicoId);
        return ResponseEntity.ok(galeria);
    }
}
