package com.produtos.api.domains.usecase.query;

import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.app.dto.response.ProductsBySubCategory;

import java.util.List;

public interface SubCategoryService {

    public List<SubCategory> findAllSubCategories();

    public SubCategory findById(Long idSubcategory);

    public ProductsBySubCategory findSubcategoryWithProducts(Long idSubcategory);
}
