package com.clclimatizacao.api.service;

import com.clclimatizacao.api.exception.ClienteNaoEncontradoException;
import com.clclimatizacao.api.exception.EquipamentoNaoEncontradoException;
import com.clclimatizacao.api.exception.NotFoundException;
import com.clclimatizacao.api.model.Cliente;
import com.clclimatizacao.api.model.Equipamento;
import com.clclimatizacao.api.repository.Clienterepository;
import com.clclimatizacao.api.repository.Equipamentorepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Equipamentoservice {
    private final Equipamentorepository equipamentorepository;
    private final Clienterepository clienterepository;

    public Equipamentoservice(Equipamentorepository equipamentorepository, Clienterepository clienterepository) {
        this.equipamentorepository = equipamentorepository;
        this.clienterepository = clienterepository;
    }

    /*Lista equipamentos ativos*/
    public List<Equipamento> listaEquipamentos(){
       return equipamentorepository.findByativo(true);
    }

    /*Lista equipamentos vencidos*/
    public List<Equipamento> listaEquipamentosVencidos(){
        LocalDate hoje = LocalDate.now();
       return equipamentorepository.findByativoAndProximaManutencaoLessThanEqual(true,hoje);
    }

    /*lista equipamentos com vencimento em 7 dias*/
    public List<Equipamento> listaQuaseVencidos(){
        LocalDate hoje = LocalDate.now();
        LocalDate limite = hoje.plusDays(7);
       return equipamentorepository.findByativoAndProximaManutencaoBetween(true, hoje, limite);
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
        equipamento.setDataUltimaManutencao(novaData);
        equipamento.setPeriodicidadeMeses(novaPeriodiciodade);
        equipamento.setProximaManutencao(equipamento.getDataUltimaManutencao().plusMonths(equipamento.getPeriodicidadeMeses()));
        return equipamentorepository.save(equipamento);
    }
    /*Desativar equipamento*/
    public void desativaEquipamento(Long id){
        Optional<Equipamento> optionalEquipamento = equipamentorepository.findById(id);
        if(optionalEquipamento.isEmpty()){
            throw new EquipamentoNaoEncontradoException("Não foi possivel encontrar equipamento com esse id!");
        }
        Equipamento equipamento = optionalEquipamento.get();
        if(equipamento.isAtivo()){
            equipamento.setAtivo(false);
        }
        equipamentorepository.save(equipamento);
    }

}
