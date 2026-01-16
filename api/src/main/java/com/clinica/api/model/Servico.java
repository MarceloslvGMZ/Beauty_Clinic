package com.clinica.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "servico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;
    private float valor;
    private boolean ativo;
}
