package com.produtos.api.services.query;

import com.produtos.api.app.exceptionhandler.ProductNotFoundException;
import com.produtos.api.domains.usecase.query.ProductService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.produtos.api.domains.message.ProductMessage.*;

@Service("serviceImplProduct")
public class ProductServiceQueryImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceQueryImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products =  productRepository.findAll();

        if(products.isEmpty()) {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
        }

        return products;
    }

    @Override
    public Optional<Product> findById(Long idProduct) {
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND_ID_MESSAGE));
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findByName(String nameProduct) {

        List<Product> products = productRepository.findByNameProduct(nameProduct);

        if(products.isEmpty()) {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND_NAME_MESSAGE);
        }

        return products;
    }

}
