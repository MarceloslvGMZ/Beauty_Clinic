package com.clinica.api.model.galeria;

import com.clinica.api.model.servico.Servico;
import org.springframework.web.multipart.MultipartFile;

public record GaleriaRequestDTO(MultipartFile image, Servico servico) {
}
