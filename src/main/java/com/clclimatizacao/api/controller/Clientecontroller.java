package com.clclimatizacao.api.controller;

import com.clclimatizacao.api.model.Cliente;
import com.clclimatizacao.api.service.Clienteservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class Clientecontroller {
    public final Clienteservice clienteservice;

    public Clientecontroller(Clienteservice clienteservice) {
        this.clienteservice = clienteservice;
    }

    @GetMapping()
    public List<Cliente> getClientes(){
        return clienteservice.clientes();
    }

    @PostMapping()
    public Cliente criaCliente(@RequestBody Cliente cliente){
        return clienteservice.criaCliente(cliente);
    }

    @PatchMapping("/{id}")
    public Cliente atualizaTelefone(@RequestParam String telefone, @PathVariable Long id){
        return clienteservice.atualizaCliente(telefone, id);
    }

    @DeleteMapping("/{id}")
    public void deletaCliente(@PathVariable Long id){
        clienteservice.desativaCliente(id);
    }

}
