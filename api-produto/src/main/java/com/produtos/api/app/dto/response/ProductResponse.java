package com.produtos.api.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String  nameProduct;
    private String  description;
    private Integer sku;
    private String  dataCreation;
    private Double  unitaryValue;
    private Integer stock;
}
