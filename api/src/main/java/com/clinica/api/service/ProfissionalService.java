package com.clinica.api.service;


import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.profissional.ProfissionalRequestDTO;
import com.clinica.api.model.profissional.ProfissionalResponseDTO;
import com.clinica.api.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalResponseDTO criarProfissional(ProfissionalRequestDTO data){
        Profissional newProfissional = new Profissional();
        newProfissional.setNome(data.nome());

        Profissional profissionalSalvo = repository.save(newProfissional);

        return new ProfissionalResponseDTO(profissionalSalvo);
    }

    public List<ProfissionalResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ProfissionalResponseDTO::new)
                .toList();
    }
}
