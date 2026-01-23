package com.clinica.api.model.galeria;

import com.clinica.api.model.servico.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "galeria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GaleriaPortfolio {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "imgurl", nullable = false)
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}
