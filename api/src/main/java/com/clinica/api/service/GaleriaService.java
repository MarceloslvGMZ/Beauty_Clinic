package com.clinica.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.clinica.api.model.galeria.GaleriaRequestDTO;
import com.clinica.api.model.galeria.GaleriaPortfolio;
import com.clinica.api.model.servico.Servico;
import com.clinica.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class GaleriaService{

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private ServicoRepository servicoRepository;

    public GaleriaPortfolio criarPortfolio(GaleriaRequestDTO data){
        Servico servico = servicoRepository.findById(data.servicoId())
                .orElseThrow(()-> new RuntimeException("Servico nao encontrado"));

        String imgUrl = null;
        if(data.image() != null){
            imgUrl = this.uploadImg(data.image());
        }

        GaleriaPortfolio portfolio = new GaleriaPortfolio();
        portfolio.setServico(servico);
        portfolio.setImgUrl(imgUrl);

        return portfolio;
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

}
