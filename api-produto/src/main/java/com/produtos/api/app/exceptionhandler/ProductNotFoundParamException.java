package com.produtos.api.app.exceptionhandler;

public class ProductNotFoundParamException extends RuntimeException {

    public ProductNotFoundParamException(String message){
        super(message);
    }
}
