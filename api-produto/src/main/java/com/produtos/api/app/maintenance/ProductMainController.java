package com.produtos.api.app.maintenance;

import com.produtos.api.app.dto.request.ProductRequest;
import com.produtos.api.domains.usecase.maintenance.ProductService;
import com.produtos.api.infra.models.Product;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductMainController {

    private ProductService productService;

    public ProductMainController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        var product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

}
