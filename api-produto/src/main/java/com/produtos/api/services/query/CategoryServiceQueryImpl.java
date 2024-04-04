package com.produtos.api.services.query;

import com.produtos.api.app.dto.response.ProductResponse;
import com.produtos.api.app.dto.response.ProductsByCategory;
import com.produtos.api.app.exceptionhandler.CategoryNotFoundException;
import com.produtos.api.app.exceptionhandler.ProductNotFoundException;
import com.produtos.api.domains.usecase.query.CategoryService;
import com.produtos.api.infra.models.Category;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.CategoryRepository;
import com.produtos.api.infra.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.produtos.api.domains.message.CategoryMessage.CATEGORY_NOT_FOUND_ID_MESSAGE;
import static com.produtos.api.domains.message.CategoryMessage.CATEGORY_NOT_FOUND_MESSAGE;

@Service
public class CategoryServiceQueryImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public CategoryServiceQueryImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long idCategory) {
        return categoryRepository.findById(idCategory)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND_ID_MESSAGE));
    }

    @Override
    public ProductsByCategory findCategoryWithProducts(Long idCategory) {

        Category category = findById(idCategory);

        List<Product> products = productRepository.findAll();

        List<ProductResponse> productsDTO = new ArrayList<>();

        if (products != null) {
            products.forEach(product -> {
                if(category.equals(product.getSubCategory().getCategory()) ) {
                    productsDTO.add(mapper.map(product, ProductResponse.class));
                }
            });
        }

        ProductsByCategory categoryAndProduct = new ProductsByCategory();

        categoryAndProduct.setCategory(category);
        categoryAndProduct.setProducts(productsDTO);

        return categoryAndProduct;
    }

}
