package com.produtos.api.infra.repositories;

import com.produtos.api.infra.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
