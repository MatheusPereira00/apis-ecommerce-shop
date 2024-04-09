package com.desconto.products.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount/all")
public class DiscountProductController {

    @GetMapping
    public String findAll(){
        return "All Discount Products";
    }
}
