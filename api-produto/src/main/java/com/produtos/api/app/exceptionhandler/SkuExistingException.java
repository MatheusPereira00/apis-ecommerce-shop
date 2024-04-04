package com.produtos.api.app.exceptionhandler;

public class SkuExistingException extends RuntimeException {

    public SkuExistingException(String message){
        super(message);
    }

}

