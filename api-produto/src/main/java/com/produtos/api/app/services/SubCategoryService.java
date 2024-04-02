package com.produtos.api.app.services;

import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.rest.dto.response.ProductsBySubCategory;

import java.util.List;

public interface SubCategoryService {

    public List<SubCategory> findAllSubCategories();

    public ProductsBySubCategory findSubcategoryaWithProducts(Long idSubCategory);
}
