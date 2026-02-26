package com.clclimatizacao.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Table_Equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Cliente clienteId;
    private String modelo;
    private String localInstalado;
    private LocalDate dataUltimaManutencao;
    private Integer periodicidadeMeses;
    private LocalDate proximaManutencao;
    private boolean ativo;

    public Equipamento(Long id, Cliente cliente, String modelo, String localInstalado,
                       LocalDate dataUltimaManutencao, Integer periodicidadeMeses, LocalDate proximaManutencao,
                       boolean ativo) {
        this.id = id;
        this.clienteId = cliente;
        this.modelo = modelo;
        this.localInstalado = localInstalado;
        this.dataUltimaManutencao = dataUltimaManutencao;
        this.periodicidadeMeses = periodicidadeMeses;
        this.proximaManutencao = proximaManutencao;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente cliente) {
        this.clienteId = cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLocalInstalado() {
        return localInstalado;
    }

    public void setLocalInstalado(String localInstalado) {
        this.localInstalado = localInstalado;
    }

    public LocalDate getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }

    public void setDataUltimaManutencao(LocalDate dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    public Integer getPeriodicidadeMeses() {
        return periodicidadeMeses;
    }

    public void setPeriodicidadeMeses(Integer periodicidadeMeses) {
        this.periodicidadeMeses = periodicidadeMeses;
    }

    public LocalDate getProximaManutencao() {
        return proximaManutencao;
    }

    public void setProximaManutencao(LocalDate proximaManutencao) {
        this.proximaManutencao = proximaManutencao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
