package com.cloudshop.productservice.controllers;

import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping(name = "/products")
    public List<Product> showProducts() {
        List<Product> all = service.findAll();
        return all;
    }
}
