package com.clclimatizacao.api.controller;

import com.clclimatizacao.api.model.Equipamento;
import com.clclimatizacao.api.service.Equipamentoservice;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/Equipamentos")
public class Equipamentocontroller {
    private final Equipamentoservice equipamentoservice;

    public Equipamentocontroller(Equipamentoservice equipamentoservice) {
        this.equipamentoservice = equipamentoservice;
    }

    @PostMapping("/{id}")
    public Equipamento criaEquipamento(@PathVariable Long id, @RequestBody Equipamento equipamento){
        return equipamentoservice.criaEquipamento(id, equipamento);
    }

    @PatchMapping("/{id}")
    public Equipamento atualizaEquipamento(@PathVariable Long id,@RequestParam LocalDate novadata, Integer novaPeriodiciodade){
        return equipamentoservice.atualizaEquipamento(id, novadata,novaPeriodiciodade);
    }

    @DeleteMapping("/{id}")
    public void desativaEquipamento(@PathVariable Long id){
        equipamentoservice.desativaEquipamento(id);
    }
}
