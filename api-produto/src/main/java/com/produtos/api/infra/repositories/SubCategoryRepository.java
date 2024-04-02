package com.produtos.api.infra.repositories;

import com.produtos.api.infra.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
