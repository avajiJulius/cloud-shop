package com.cloudshop.productservice.controllers;

import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.services.ProductService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController{

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @Override
    public List<Product> showProducts() {
        List<Product> result = service.findAllAvailable();
        return result;
    }

//
//    @PostMapping(name = "/create")
//    public String createProduct(@ModelAttribute(name = "product") Product product) {
//        service.createOrUpdate(product);
//        return "success create!";
//    }
//
//    @PostMapping (name = "/update/{id}")
//    public String updateProduct(@PathVariable(name = "id") Long id) {
//        Product pro = service.findById(id);
//        service.createOrUpdate(pro);
//        return "success update!";
//    }



}
