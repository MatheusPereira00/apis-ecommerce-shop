package com.produtos.api.app.services.impl;

import com.produtos.api.app.services.SubCategoryService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.infra.repositories.ProductRepository;
import com.produtos.api.infra.repositories.SubCategoryRepository;
import com.produtos.api.rest.dto.response.ProductDTO;
import com.produtos.api.rest.dto.response.ProductsBySubCategory;
import com.produtos.api.rest.exceptionhandler.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.produtos.api.domains.message.SubCategoryMessage.SUBCATEGORY_NOT_FOUND_MESSAGE;

@Service("serviceImplSubCategory")
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, ProductRepository productRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SubCategory> findAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory findById(Long idSubcategory) {
        return subCategoryRepository.findById(idSubcategory)
                .orElseThrow(() -> new NotFoundException(SUBCATEGORY_NOT_FOUND_MESSAGE));
    }

    @Override
    public ProductsBySubCategory findSubcategoryWithProducts(Long idSubcategory) {

        SubCategory subCategory = findById(idSubcategory);

        List<Product> products = productRepository.findBySubCategory(subCategory);

        List<ProductDTO> productsDTO = new ArrayList<>();

        if (products != null) {
            products.forEach(product -> {
                ProductDTO produtoDTO = mapper.map(product, ProductDTO.class);
                productsDTO.add(produtoDTO);
            });
        }

        ProductsBySubCategory subcategoryAndProduct = new ProductsBySubCategory();

        subcategoryAndProduct.setSubCategory(subCategory);
        subcategoryAndProduct.setProducts(productsDTO);

        return subcategoryAndProduct;
    }

}
