package com.produtos.api.rest.dto.response;

import com.produtos.api.infra.models.Product;
import com.produtos.api.infra.models.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsBySubCategory {

    SubCategory subCategory;

    List<Product> products;
}
