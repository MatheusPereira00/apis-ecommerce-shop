package com.produtos.api.services.query;

import com.produtos.api.app.exceptionhandler.ProductNotFoundException;
import com.produtos.api.app.exceptionhandler.SubCategoryNotFoundException;
import com.produtos.api.domains.usecase.query.SubCategoryService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.infra.repositories.ProductRepository;
import com.produtos.api.infra.repositories.SubCategoryRepository;
import com.produtos.api.app.dto.response.ProductResponse;
import com.produtos.api.app.dto.response.ProductsBySubCategory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.produtos.api.domains.message.SubCategoryMessage.SUBCATEGORY_NOT_FOUND_ID__MESSAGE;

@Service("serviceImplSubCategory")
public class SubCategoryServiceQueryImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public SubCategoryServiceQueryImpl(SubCategoryRepository subCategoryRepository, ProductRepository productRepository) {
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
                .orElseThrow(() -> new SubCategoryNotFoundException(SUBCATEGORY_NOT_FOUND_ID__MESSAGE));
    }

    @Override
    public ProductsBySubCategory findSubcategoryWithProducts(Long idSubcategory) {

        SubCategory subCategory = findById(idSubcategory);

        List<Product> products = productRepository.findBySubCategory(subCategory);

        List<ProductResponse> productsDTO = new ArrayList<>();

        if (products != null) {
            products.forEach(product -> {
                ProductResponse produtoDTO = mapper.map(product, ProductResponse.class);
                productsDTO.add(produtoDTO);
            });
        }

        ProductsBySubCategory subcategoryAndProduct = new ProductsBySubCategory();

        subcategoryAndProduct.setSubCategory(subCategory);
        subcategoryAndProduct.setProducts(productsDTO);

        return subcategoryAndProduct;
    }

}
