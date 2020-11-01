package com.cloudshop.productservice.services;


import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.exceptions.NullProductIdException;
import com.cloudshop.productservice.exceptions.ProductModificationException;
import com.cloudshop.productservice.exceptions.ProductNotFoundException;
import com.cloudshop.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }



    @Override
    public Product createOrUpdate(Product product) {
        Product result = null;
        try {
            Long id = product.getProductId();
            Optional<Product> optional = repository.findById(id);

            if(!optional.isPresent()) {
                product.setOperation("C");
            } else {
                product.setOperation("U");
            }

            result = repository.save(product);
        } catch (IllegalArgumentException exception) {
            throw new ProductModificationException("Cannot create or update product", exception);
        }
        return result;
    }



    @Override
    public void delete(Long id) {
        try {
            Optional<Product> product = repository.findById(id);
            if(!product.isPresent()) {
                throw new ProductNotFoundException("Not found product by this id");
            }
            Product result = product.get();
            result.setAvailable(false);
            result.setOperation("D");
            repository.save(result);
        } catch (IllegalArgumentException exception) {
            throw new ProductModificationException("Cannot delete product", exception);
        }

    }

    @Override
    public List<Product> findAll() {
        List<Product> result = repository.findAll();
        if(result.isEmpty()) {
            throw new ProductNotFoundException("No product in the database");
        }
        return result;
    }

    @Override
    public List<Product> findAllAvailable() {
        List<Product> result = repository.findByIsAvailableTrue();
        if(result.isEmpty()) {
            throw new ProductNotFoundException("No available product in the database");
        }
        return result;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = Optional.empty();
        try {
            product = repository.findById(id);
            if (!product.isPresent()) {
                throw new ProductNotFoundException("Not found product by this id");
            }
        } catch (IllegalArgumentException exception) {
            throw new NullProductIdException("Product ID is null", exception);
        }
        return product.get();
    }


}
