package com.produtos.api.app.services.impl;

import com.produtos.api.app.services.SubCategoryService;
import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.infra.repositories.ProductRepository;
import com.produtos.api.infra.repositories.SubCategoryRepository;
import com.produtos.api.rest.dto.response.ProductsBySubCategory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private SubCategoryRepository subCategoryRepository;
    private ProductRepository productRepository;

    private ModelMapper mapper = new ModelMapper();

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, ProductRepository productRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SubCategory> findAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public ProductsBySubCategory findSubcategoryaWithProducts(Long idSubCategory) {
        return null;
    }
}
