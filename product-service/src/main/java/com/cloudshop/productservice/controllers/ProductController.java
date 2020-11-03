package com.cloudshop.productservice.controllers;

import com.cloudshop.productservice.entities.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductController {
    @GetMapping("/")
    List<Product> showProducts();

    @GetMapping("/search")
    List<Product> searchProductsWithPagingAndFilter(Model model,
                                                    Optional<Integer> page,
                                                    String title,
                                                    Double minPrice,
                                                    Double maxPrice);

    @PostMapping("/create")
    String createProduct(@ModelAttribute(name = "product") Product product);

    @PutMapping("/update/{id}")
    String updateProduct(@PathVariable(name = "id") Product product);

    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable(name = "id") Long id);
}
