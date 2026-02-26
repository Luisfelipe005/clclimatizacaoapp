package com.clclimatizacao.api.service;

import com.clclimatizacao.api.exception.ClienteNaoEncontradoException;
import com.clclimatizacao.api.exception.EquipamentoNaoEncontradoException;
import com.clclimatizacao.api.exception.NotFoundException;
import com.clclimatizacao.api.model.Cliente;
import com.clclimatizacao.api.model.Equipamento;
import com.clclimatizacao.api.repository.Clienterepository;
import com.clclimatizacao.api.repository.Equipamentorepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class Equipamentoservice {
    private final Equipamentorepository equipamentorepository;
    private final Clienterepository clienterepository;

    public Equipamentoservice(Equipamentorepository equipamentorepository, Clienterepository clienterepository) {
        this.equipamentorepository = equipamentorepository;
        this.clienterepository = clienterepository;
    }


    /*Criar equipamento*/
    public Equipamento criaEquipamento(Long clienteId, Equipamento equipamento){
       Optional<Cliente> optionalCliente = clienterepository.findById(clienteId);
       if(optionalCliente.isEmpty()){
           throw new ClienteNaoEncontradoException("Cliente não foi identificado por esse id!");
       } else if (equipamento.getModelo().isEmpty() || equipamento.getLocalInstalado().isEmpty()) {
           throw new NotFoundException("Modelo ou Local não pode ser vazio");
       } else if (equipamento.getDataUltimaManutencao() == null || equipamento.getPeriodicidadeMeses() > 0) {
           throw new NotFoundException("Data de instalação não pode ser estar vazia");
       }

       LocalDate proxima = equipamento.getDataUltimaManutencao().plusMonths(equipamento.getPeriodicidadeMeses());
       equipamento.setProximaManutencao(proxima);

       return equipamentorepository.save(equipamento);
    }

    /*Atualizar Equipamento*/
    //Ver esse metodo
    public Equipamento atualizaEquipamento(Long id, LocalDate novaData, Integer novaPeriodiciodade){
        Optional<Equipamento> optionalEquipamento = equipamentorepository.findById(id);
        if(optionalEquipamento.isEmpty()){
            throw new EquipamentoNaoEncontradoException("Equipamento com esse id não foi encontrado");
        }
        Equipamento equipamento = optionalEquipamento.get();
        return equipamentorepository.save(equipamento);
    }
    /*Desativar equipamento*/


}
