package com.clinica.api.repository;

import com.clinica.api.model.agendamento.Agendamento;
import com.clinica.api.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    @Query("Select a from Agendamento a WHERE  a.cliente.nome LIKE %:name%")
    List<Agendamento> findByClienteName(String name);

    @Query("Select a from Agendamento a WHERE a.date >= :data")
    List<Agendamento> findUpcoming(Date data);

    @Query("SELECT DISTINCT a FROM Agendamento a JOIN a.servicos s WHERE s.nome LIKE %:servico%")    List<Agendamento> findByServico(String servico);

    @Query("Select a from Agendamento a WHERE a.status LIKE %:status%")
    List<Agendamento> findByStatus(String status);

    @Query("Select a from Agendamento a WHERE a.date BETWEEN :inicio AND :fim")
    List<Agendamento> findBetweenDates(Date inicio, Date fim);

    @Query("SELECT SUM(s.valor) FROM Agendamento a JOIN a.servicos s WHERE a.date BETWEEN :inicio AND :fim AND a.status = 'CONCLUIDO'")
    Double somarFaturamentoDoPeriodo(Date inicio, Date fim);
}
