package com.clclimatizacao.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Table_Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Boolean ativo;

    public Cliente(Long id, String nome, String telefone, Boolean ativo, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.ativo = true;
    }

    public Cliente() {
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
