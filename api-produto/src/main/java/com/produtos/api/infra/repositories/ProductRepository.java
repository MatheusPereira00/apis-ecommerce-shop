package com.produtos.api.infra.repositories;

import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByNameProduct(String nameProduct);

    public Product findBySku (int sku);

    public List<Product> findBySubCategory(SubCategory subCategory);

}
