package com.produtos.api.app.exceptionhandler;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String message){
        super(message);
    }
}
