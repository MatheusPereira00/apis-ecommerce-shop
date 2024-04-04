package com.produtos.api.app.query;

import com.produtos.api.app.exceptionhandler.SubCategoryNotFoundException;
import com.produtos.api.domains.usecase.query.SubCategoryService;
import com.produtos.api.infra.models.SubCategory;
import com.produtos.api.app.dto.response.ProductsBySubCategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.produtos.api.domains.message.SubCategoryMessage.SUBCATEGORY_NOT_FOUND_MESSAGE;

@RestController
@RequestMapping("/product/subcategory")
public class SubCategoryController {

    private SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<SubCategory>> findAll(){

        List<SubCategory> subcategorias = subCategoryService.findAllSubCategories();

        if (subcategorias.isEmpty()) {
            throw new SubCategoryNotFoundException(SUBCATEGORY_NOT_FOUND_MESSAGE);
        }

        return new ResponseEntity<>(subcategorias, HttpStatus.OK);

    }

    @GetMapping(path="/{idSubCategory}")
    public ResponseEntity<ProductsBySubCategory> findBydId(@PathVariable("idSubCategory") Long idSubCategory){
        ProductsBySubCategory subcategoryProd = subCategoryService.findSubcategoryWithProducts(idSubCategory);
        return new ResponseEntity<>(subcategoryProd, HttpStatus.OK);
    }

}
