package com.produtos.api.app.resourceQuery;

import com.produtos.api.app.dto.response.ProductsByCategory;
import com.produtos.api.app.dto.response.ProductsBySubCategory;
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
            throw new EntityNotFoundException("Ops! Ainda não há sub_categorias cadastradas");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(path="/{idCategory}")
    public ResponseEntity<ProductsByCategory> findBydId(@PathVariable("idCategory") Long idCategory){
        ProductsByCategory categoryProd = categoryService.findCategoryWithProducts(idCategory);
        return new ResponseEntity<>(categoryProd, HttpStatus.OK);
    }

}
