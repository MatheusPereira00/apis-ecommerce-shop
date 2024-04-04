package com.produtos.api.app.exceptionhandler.handler;

import com.produtos.api.app.exceptionhandler.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CategoryHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> categoryNotFoundException (CategoryNotFoundException e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }
}
