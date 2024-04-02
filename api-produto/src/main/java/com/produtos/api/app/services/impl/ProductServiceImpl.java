package com.produtos.api.app.services.impl;

import com.produtos.api.app.services.ProductService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.ProductRepository;
import com.produtos.api.rest.exceptionhandler.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.produtos.api.domains.message.ProductMessage.PRODUCT_NOT_FOUND_MESSAGE;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {return productRepository.findAll();}

    @Override
    public Optional<Product> findById(Long idProduct) {
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new NotFoundException(PRODUCT_NOT_FOUND_MESSAGE));
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findByName(String nameProduct) {

        List<Product> products = productRepository.findByNameProduct(nameProduct);

        if(products.size() == 0) {
            throw new EntityNotFoundException(
                    "Não foi possível encontrar um produto com este nome. "
                            + "Verifique e tente novamente.");
        }

        return products;
    }

}
