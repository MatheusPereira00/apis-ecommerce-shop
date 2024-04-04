package com.produtos.api.app.dto.response;

import com.produtos.api.infra.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsByCategory {

    Category category;

    List<ProductDTO> products;
}
