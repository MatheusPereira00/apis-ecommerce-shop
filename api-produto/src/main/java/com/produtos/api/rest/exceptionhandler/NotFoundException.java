package com.produtos.api.rest.exceptionhandler;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
