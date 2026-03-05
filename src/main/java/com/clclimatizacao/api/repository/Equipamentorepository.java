package com.clclimatizacao.api.repository;

import com.clclimatizacao.api.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface Equipamentorepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByativo(boolean ativo);
    List<Equipamento> findByativoAndProximaManutencaoBetween(boolean ativo, LocalDate hoje, LocalDate limite);
    List<Equipamento> findByativoAndProximaManutencaoLessThanEqual(boolean ativo, LocalDate proximaData);
}
