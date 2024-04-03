package com.produtos.api.app.exceptionhandler;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
