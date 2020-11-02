package com.cloudshop.productservice.controllers;

import com.cloudshop.productservice.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProductController {
    @GetMapping("/")
    List<Product> showProducts();
}
