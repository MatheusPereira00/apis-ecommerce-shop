package com.produtos.api.app.exceptionhandler;

public class ProductCreatedException extends RuntimeException{
    public ProductCreatedException(String message){
        super(message);
    }
}
