package com.produtos.api.app.query;

import com.produtos.api.app.dto.response.ProductsByCategory;
import com.produtos.api.app.exceptionhandler.CategoryNotFoundException;
import com.produtos.api.domains.usecase.query.CategoryService;
import com.produtos.api.infra.models.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.produtos.api.domains.message.CategoryMessage.CATEGORY_NOT_FOUND_MESSAGE;

@RestController
@RequestMapping("/product/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findAll();

        if(categories.isEmpty()){
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND_MESSAGE);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(path="/{idCategory}")
    public ResponseEntity<ProductsByCategory> findBydId(@PathVariable("idCategory") Long idCategory){
        ProductsByCategory categoryProd = categoryService.findCategoryWithProducts(idCategory);
        return new ResponseEntity<>(categoryProd, HttpStatus.OK);
    }

}
