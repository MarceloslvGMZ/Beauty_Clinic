package com.clinica.api.service;


import com.clinica.api.model.profissional.Profissional;
import com.clinica.api.model.profissional.ProfissionalRequestDTO;
import com.clinica.api.model.profissional.ProfissionalResponseDTO;
import com.clinica.api.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public Profissional criarProfissional(ProfissionalRequestDTO data){
        Profissional newProfissional = new Profissional();
        newProfissional.setNome(data.nome());

        return repository.save(newProfissional);
    }

    public List<ProfissionalResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(ProfissionalResponseDTO::new)
                .toList();
    }
}
