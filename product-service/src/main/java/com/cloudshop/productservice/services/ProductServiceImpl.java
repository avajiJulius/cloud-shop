package com.cloudshop.productservice.services;


import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }



    @Override
    public void createOrUpdate(Product product) {
        repository.save(product);
    }



    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        List<Product> result = repository.findAll();
        return result;
    }
}
