package com.produtos.api.domains.usecase.query;

import com.produtos.api.app.dto.response.ProductsByCategory;
import com.produtos.api.app.dto.response.ProductsBySubCategory;
import com.produtos.api.infra.models.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public Category findById(Long idSubcategory);

    public ProductsByCategory findCategoryWithProducts(Long idCategory);
}
