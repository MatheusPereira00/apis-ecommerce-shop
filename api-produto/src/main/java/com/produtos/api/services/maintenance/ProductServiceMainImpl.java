package com.produtos.api.services.maintenance;

import com.produtos.api.app.exceptionhandler.ProductNotFoundException;
import com.produtos.api.app.exceptionhandler.SkuExistingException;
import com.produtos.api.domains.usecase.maintenance.ProductService;
import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.produtos.api.domains.message.ProductMessage.PRODUCT_FOUND_SKU_MESSAGE;
import static com.produtos.api.domains.message.ProductMessage.PRODUCT_NOT_FOUND_DELETE_MESSAGE;


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

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long idProduct, Product product) {
        product.setIdProduct(idProduct);
        Optional<Product> productED = productRepository.findById(idProduct);

        if (productED.isEmpty()){
            throw new RuntimeException("Nenhum produto com esse id foi encontrado");
        }

        return productRepository.save(product);

        // LANÇAR MENSAGEM DE SUCESSO -- //
        // VERIFICAÇÃO DE CAMPOS NULOS -- //
        // VERIFICAÇÃO DE CAMPOS INVALIDOS -- //
        // CRIAR EXCEPTIONS + HANDLERS -- //

    }

    @Override
    public void deleteProduct(Long id) {

        Product productFound = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND_DELETE_MESSAGE));

            productRepository.delete(productFound);

    }

}
