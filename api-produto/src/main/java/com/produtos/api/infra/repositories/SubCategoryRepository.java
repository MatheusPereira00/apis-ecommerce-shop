package com.produtos.api.infra.repositories;

import com.produtos.api.infra.models.Category;
import com.produtos.api.infra.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    public List<SubCategory> findByCategory(Category category);
}
