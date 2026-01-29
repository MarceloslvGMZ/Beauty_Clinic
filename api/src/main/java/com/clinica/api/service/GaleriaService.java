package com.clinica.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.clinica.api.model.galeria.GaleriaRequestDTO;
import com.clinica.api.model.galeria.GaleriaPortfolio;
import com.clinica.api.model.galeria.GaleriaResponseDTO;
import com.clinica.api.model.servico.Servico;
import com.clinica.api.repository.GaleriaRepository;
import com.clinica.api.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GaleriaService{

    @Value("${aws.bucket.name}")
    private String bucketName;


    private final AmazonS3 s3Client;


    private final ServicoRepository servicoRepository;

    private final GaleriaRepository galeriaRepository;

    public GaleriaResponseDTO criarPortfolio(GaleriaRequestDTO data){
        Servico servico = servicoRepository.findById(data.servicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrado."));

        String imgUrl = null;
        if(data.image() != null){
            imgUrl = this.uploadImg(data.image());
        }

        GaleriaPortfolio portfolio = new GaleriaPortfolio();
        portfolio.setServico(servico);
        portfolio.setImgUrl(imgUrl);

        GaleriaPortfolio newPortfolio= galeriaRepository.save(portfolio);

        return new GaleriaResponseDTO(newPortfolio);
    }

    private String uploadImg(MultipartFile multipartFile) {
        String fileName = UUID.randomUUID().toString() + "-" + multipartFile.getOriginalFilename();

        try{
            File file = this.convertMultipartToFile(multipartFile);
            s3Client.putObject(bucketName, fileName, file);
            file.delete();
            return s3Client.getUrl(bucketName, fileName).toString();
        }catch(Exception e){
            System.out.println("Erro ao Subir arquivo");
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {

        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

    public List<GaleriaResponseDTO> listarPortfolioPorServico(UUID servicoId){
        List<GaleriaPortfolio> list = galeriaRepository.findByServicoId(servicoId);

        return list.stream()
                .map(GaleriaResponseDTO::new)
                .toList();
    }

}
