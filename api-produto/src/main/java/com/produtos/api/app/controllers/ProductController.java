package com.produtos.api.app.controllers;

import com.produtos.api.app.services.ProductService;
import com.produtos.api.infra.models.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();

        if(products.size() == 0) {
            throw new EntityNotFoundException(
                    "Não há produtos cadastrados");
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/{idProduct}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long idProduct) {
        Optional<Product> product_id = productService.findById(idProduct);
        return new ResponseEntity<Optional<Product>>(product_id, HttpStatus.OK);
    }

    @GetMapping(path = "/name/{nameProduct}")
    public ResponseEntity<List<Product>> consultingByName(@PathVariable String nameProduct) {
        List<Product> produtos = productService.findByName(nameProduct);
        return new ResponseEntity<List<Product>>(produtos, HttpStatus.OK);
    }

}
