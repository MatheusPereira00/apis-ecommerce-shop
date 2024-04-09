package com.produtos.api.app.maintenance;

import com.produtos.api.app.dto.request.ProductRequest;
import com.produtos.api.app.exceptionhandler.ProductCreatedException;
import com.produtos.api.domains.usecase.maintenance.ProductService;
import com.produtos.api.infra.models.Product;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.produtos.api.domains.message.ProductMessage.PRODUCT_CREATE_MESSAGE;


@RestController
@RequestMapping("/product")
public class ProductMainController {

    private ProductService productService;

    public ProductMainController(ProductService productService) {
        this.productService = productService;
    }


    /*
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    Product product1 = productService.createProduct(product);

    return ResponseEntity.status(HttpStatus.CREATED).body(new RuntimeException(PRODUCT_CREATE_MESSAGE));
    return ResponseEntity.status(HttpStatus.CREATED).body(new ProductCreatedException(PRODUCT_CREATE_MESSAGE));

    return ResponseEntity.status(HttpStatus.CREATED).body(List.of(product1, "Produto criado com sucesso"));
    */


    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        var product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso");
    }

    @PutMapping(path="/update/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long idProduct, @RequestBody @Valid Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(idProduct, product));
    }

}
