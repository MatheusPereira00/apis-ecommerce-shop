package com.produtos.api.app.exceptionhandler.handler;

import com.produtos.api.app.exceptionhandler.SubCategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SubCategoryHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SubCategoryNotFoundException.class)
    public ResponseEntity<Object> subCategoryNotFoundIdException (SubCategoryNotFoundException e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }
}
