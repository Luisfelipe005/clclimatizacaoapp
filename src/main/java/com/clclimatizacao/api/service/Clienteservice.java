package com.clclimatizacao.api.service;

import com.clclimatizacao.api.exception.ClienteNaoEncontradoexception;
import com.clclimatizacao.api.exception.NomeVazioexception;
import com.clclimatizacao.api.exception.TelefoneVazioexception;
import com.clclimatizacao.api.model.Cliente;
import com.clclimatizacao.api.repository.Clienterepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Clienteservice {
    private final Clienterepository clienterepository;

    public Clienteservice(Clienterepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    /*Lista clientes*/
    public List<Cliente> clientes(){
        return clienterepository.findAll();
    }

    /*Criar cliente*/
    public Cliente criaCliente(Cliente cliente){
        if(cliente.getNome().isEmpty()){
            throw new NomeVazioexception("O nome do cliente não pode estar vazio!");
        }
        else if (cliente.getTelefone().isEmpty()){
            throw new TelefoneVazioexception("O telefone não pode estar vazio!");
        }
        return clienterepository.save(cliente);
    }

    /*Atualiza cliente (Apenas o telefone)*/
    public Cliente atualizaCliente(String telefone,Long id){
        Optional<Cliente> optionalCliente = clienterepository.findById(id);
        if(optionalCliente.isEmpty()){
            throw new ClienteNaoEncontradoexception("Não achamos cliente por esse id: " + id);
        }
        Cliente cliente = optionalCliente.get();
        cliente.setTelefone(telefone);
        return  clienterepository.save(cliente);
    }

    /*Desativa cliente*/
    public void desativaCliente(Long id){
        Optional<Cliente> optionalCliente = clienterepository.findById(id);
        if (optionalCliente.isEmpty()){
            throw new ClienteNaoEncontradoexception("O cliente com esse id não foi encontrado");
        }
        Cliente cliente = optionalCliente.get();
        cliente.setAtivo(false);
        clienterepository.save(cliente);
    }

}
