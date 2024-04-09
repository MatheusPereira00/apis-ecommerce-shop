package com.produtos.api.domains.usecase.maintenance;

import com.produtos.api.infra.models.Product;

public interface ProductService {

    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product product);

    public void deleteProduct(Long id);

}
