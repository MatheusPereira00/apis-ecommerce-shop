package com.produtos.api.services.maintenance;

import com.produtos.api.app.exceptionhandler.ProductNotCreated;
import com.produtos.api.app.exceptionhandler.SkuExistingException;
import com.produtos.api.domains.usecase.maintenance.ProductService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.produtos.api.domains.message.ProductMessage.PRODUCT_FOUND_SKU_MESSAGE;


@Service
public class ProductServiceMainImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ProductServiceMainImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {

        Product sku = productRepository.findBySku(product.getSku());

        if(sku != null){
            throw new SkuExistingException(PRODUCT_FOUND_SKU_MESSAGE);
        }

        return productRepository.save(product);}

}
