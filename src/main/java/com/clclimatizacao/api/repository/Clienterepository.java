package com.clclimatizacao.api.repository;

import com.clclimatizacao.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clienterepository extends JpaRepository<Cliente, Long> {
}
