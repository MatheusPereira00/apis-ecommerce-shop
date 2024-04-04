package com.produtos.api.app.query;

import com.produtos.api.app.exceptionhandler.ProductNotFoundParamException;
import com.produtos.api.domains.usecase.query.ProductService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.produtos.api.domains.message.ProductMessage.PRODUCT_NOT_FOUND_WITH_PARAM_MESSAGE;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/{idProduct}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long idProduct) {
        Optional<Product> product_id = productService.findById(idProduct);
        return new ResponseEntity<Optional<Product>>(product_id, HttpStatus.OK);
    }

    @GetMapping(path = "/name/{nameProduct}")
    public ResponseEntity<List<Product>> findByName(@PathVariable String nameProduct) {
        List<Product> produtos = productService.findByName(nameProduct);
        return new ResponseEntity<List<Product>>(produtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listBy(Product productResponse){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example productResponseExample =  Example.of(productResponse, matcher);
        List<Product> lista = productRepository.findAll(productResponseExample);

        if (lista.isEmpty()) {
            throw new ProductNotFoundParamException(PRODUCT_NOT_FOUND_WITH_PARAM_MESSAGE);
        }
        return ResponseEntity.ok(lista);
    }

}
