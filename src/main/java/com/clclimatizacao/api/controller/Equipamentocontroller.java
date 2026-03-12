package com.clclimatizacao.api.controller;

import com.clclimatizacao.api.model.Cliente;
import com.clclimatizacao.api.model.Equipamento;
import com.clclimatizacao.api.service.Equipamentoservice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Equipamentos")
public class Equipamentocontroller {
    private final Equipamentoservice equipamentoservice;

    public Equipamentocontroller(Equipamentoservice equipamentoservice) {
        this.equipamentoservice = equipamentoservice;
    }
    @GetMapping()
    public List<Equipamento> listaEquipamentos(){
        return equipamentoservice.listaEquipamentos();
    }

    @GetMapping("/Vencidos")
    public List<Equipamento> listaVencidos(){
        return equipamentoservice.listaEquipamentosVencidos();
    }

    @GetMapping("/ProxVencidos")
    public List<Equipamento> listaVencidosEmSeteDias(){
        return equipamentoservice.listaQuaseVencidos();
    }

    @PostMapping()
    public Equipamento criaEquipamento(@RequestBody Equipamento equipamento){
        return equipamentoservice.criaEquipamento(equipamento);
    }

    @PatchMapping("/{id}")
    public Equipamento atualizaEquipamento(@PathVariable Long id,@RequestParam LocalDate novaData, Integer novaPeriodiciodade){
        return equipamentoservice.atualizaEquipamento(id, novaData,novaPeriodiciodade);
    }

    @DeleteMapping("/{id}")
    public void desativaEquipamento(@PathVariable Long id){
        equipamentoservice.desativaEquipamento(id);
    }
}
