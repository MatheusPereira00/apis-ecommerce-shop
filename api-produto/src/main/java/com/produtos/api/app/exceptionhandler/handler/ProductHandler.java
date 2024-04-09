package com.produtos.api.app.exceptionhandler.handler;

import com.produtos.api.app.exceptionhandler.ProductCreatedException;
import com.produtos.api.app.exceptionhandler.ProductNotFoundException;
import com.produtos.api.app.exceptionhandler.ProductNotFoundParamException;
import com.produtos.api.app.exceptionhandler.SkuExistingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ProductHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SkuExistingException.class)
    public ResponseEntity<Object> skuExistingException (SkuExistingException e){

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFoundIdException (ProductNotFoundException e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundParamException.class)
    public ResponseEntity<Object> productNotFoundWithParamException (ProductNotFoundParamException e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }

    @ExceptionHandler(ProductCreatedException.class)
    public ResponseEntity<Object> productCreatedException (ProductCreatedException e){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("ErrorMessage:", "")
                .body(e.getMessage());
    }

}
