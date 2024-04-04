package com.produtos.api.app.exceptionhandler;

public class ProductNotCreated extends RuntimeException {

    public ProductNotCreated(String message){
        super(message);
    }
}
