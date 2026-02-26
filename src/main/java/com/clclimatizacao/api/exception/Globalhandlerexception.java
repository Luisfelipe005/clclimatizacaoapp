package com.clclimatizacao.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Globalhandlerexception {

    @ExceptionHandler(NomeVazioexception.class)
    public ResponseEntity<String> responseEntity(NomeVazioexception nomeVazioexception){
        return ResponseEntity.status(400).body(nomeVazioexception.getMessage());
    }

    @ExceptionHandler(TelefoneVazioexception.class)
    public ResponseEntity<String> responseEntity2(TelefoneVazioexception telefoneVazioexception){
        return ResponseEntity.status(400).body(telefoneVazioexception.getMessage());
    }

    @ExceptionHandler(ClienteNaoEncontradoexception.class)
    public ResponseEntity<String> responseEntity3(ClienteNaoEncontradoexception clienteNaoEncontradoexception){
        return ResponseEntity.status(404).body(clienteNaoEncontradoexception.getMessage());
    }
}
