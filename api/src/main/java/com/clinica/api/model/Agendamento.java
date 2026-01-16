package com.clinica.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "agendamento")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue
    private UUID id;
    private String status;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

}
