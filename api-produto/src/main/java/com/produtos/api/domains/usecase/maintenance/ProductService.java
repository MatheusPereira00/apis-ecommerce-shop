package com.produtos.api.domains.usecase.maintenance;

import com.produtos.api.app.dto.request.ProductRequest;
import com.produtos.api.infra.models.Product;

import java.util.Optional;

public interface ProductService {

    public Product createProduct(Product product);

}
