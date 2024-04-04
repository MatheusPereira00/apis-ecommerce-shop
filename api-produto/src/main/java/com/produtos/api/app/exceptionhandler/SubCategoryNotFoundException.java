package com.produtos.api.app.exceptionhandler;

public class SubCategoryNotFoundException extends RuntimeException {

    public SubCategoryNotFoundException(String message){
        super(message);
    }
}
