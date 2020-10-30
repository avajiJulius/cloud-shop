package com.cloudshop.productservice.services;

import com.cloudshop.productservice.entities.Product;

import java.util.List;

public interface ProductService {
    void createOrUpdate(Product product);
    void delete(Long id);
    List<Product> findAll();
}
