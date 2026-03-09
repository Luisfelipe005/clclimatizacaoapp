package com.clclimatizacao.api.exception;

public class ClienteInativoException extends RuntimeException{
    public ClienteInativoException(String message) {
        super(message);
    }
}
