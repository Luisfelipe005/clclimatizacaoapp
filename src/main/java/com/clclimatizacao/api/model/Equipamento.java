package com.clclimatizacao.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Table_Equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Cliente cliente;
    private String modelo;
    private String localInstalado;
    private LocalDate dataInstalacao;
    private LocalDate dataUltimaManutencao;
    private Integer periodicidadeMeses;
    private LocalDate proximaManutencao;
    private boolean ativo;

    public Equipamento(Long id, Cliente cliente, String modelo, String localInstalado, LocalDate dataInstalacao,
                       LocalDate dataUltimaManutencao, Integer periodicidadeMeses, LocalDate proximaManutencao,
                       boolean ativo) {
        this.id = id;
        this.cliente = cliente;
        this.modelo = modelo;
        this.localInstalado = localInstalado;
        this.dataInstalacao = dataInstalacao;
        this.dataUltimaManutencao = dataUltimaManutencao;
        this.periodicidadeMeses = periodicidadeMeses;
        this.proximaManutencao = proximaManutencao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
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
