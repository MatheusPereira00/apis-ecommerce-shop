package com.produtos.api.domains.usecase.query;

import com.produtos.api.infra.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService  {

    public List<Product> findAll();

    public Optional<Product> findById(Long idProduct);

    List<Product> findByName(String nameProduct);
}
