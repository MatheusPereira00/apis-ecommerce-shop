package com.produtos.api.infra.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column
    private String nameProduct;

    @Column
    private String description;

    @Column
    private Integer sku;

    @Column
    private String dataCreation;

    @Column
    private Double unitaryValue;

    @Column
    private Integer stock;

    @ManyToOne
    private SubCategory subCategory;

}
