package com.produtos.api.app.dto.request;

import com.produtos.api.infra.models.SubCategory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest (
        @Size(max = 5, message = "maximo de 5 characters")
        @NotBlank ( message = "name product não pode ser nulo") String nameProduct,
        @NotBlank ( message = "description não pode ser nulo") String description,
        @NotNull  ( message = "sku não pode ser nulo") Integer sku,
        @NotBlank ( message = "data creation não pode ser nulo")  String dataCreation,
        @NotNull  ( message = "unitary value não pode ser nulo")  Double unitaryValue,
        @NotNull  ( message = "stock não pode ser nulo")  Integer stock,
        @NotNull  ( message = "subcategory não pode ser nulo") SubCategory subCategory )
{}
