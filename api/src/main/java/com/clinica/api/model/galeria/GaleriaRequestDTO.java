package com.clinica.api.model.galeria;



import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record GaleriaRequestDTO(MultipartFile image, UUID servicoId) {
}
