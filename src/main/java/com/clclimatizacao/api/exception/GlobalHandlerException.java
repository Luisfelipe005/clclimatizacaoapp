package com.clclimatizacao.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> responseEntity(NotFoundException nomeVazioexception){
        return ResponseEntity.status(400).body(nomeVazioexception.getMessage());
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<String> responseEntity2(ClienteNaoEncontradoException clienteNaoEncontradoexception){
        return ResponseEntity.status(404).body(clienteNaoEncontradoexception.getMessage());
    }

    @ExceptionHandler(EquipamentoNaoEncontradoException.class)
    public ResponseEntity<String> responseEntity3(EquipamentoNaoEncontradoException equipamentoNaoEncontradoException){
        return ResponseEntity.status(404).body(equipamentoNaoEncontradoException.getMessage());
    }
}
