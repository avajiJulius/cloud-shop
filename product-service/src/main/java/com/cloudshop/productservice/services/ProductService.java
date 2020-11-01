package com.cloudshop.productservice.services;

import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.exceptions.ProductModificationException;
import com.cloudshop.productservice.exceptions.NullProductIdException;
import com.cloudshop.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    /**
     * Create or updates a given product. Add {@literal operation} "C" for create operation, "U" for update operation.
     *
     * @param product must not be {@literal null}.
     * @return the saved or updated product; will never be {@literal null}.
     * @throws ProductModificationException in case the given {@literal product} is {@literal null}.
     */
    Product createOrUpdate(Product product);

    /**
     * Set {@literal available} to false and change {@literal operation} to "D"
     *
     * @param id must not be {@literal null}.
     * @throws ProductModificationException in case the given {@literal id} is {@literal null}.
     * @throws ProductNotFoundException if {@literal product} is not found.
     */
    void delete(Long id);

    /**
     * Retrieves all products.
     *
     * @return list of all products.
     * @throws ProductNotFoundException if there is no product in the database.
     */
    List<Product> findAll();

    /**
     * Retrieves all available products.
     *
     * @return list of all available products.
     * @throws ProductNotFoundException if there is no available product in the database.
     */
    List<Product> findAllAvailable();

    /**
     * Retrieves an product by its id.
     *
     * @param id must not be {@literal null}.
     * @return the product with the given id.
     * @throws NullProductIdException if {@literal id} is {@literal null}
     * @throws ProductNotFoundException if {@literal product} is not found.
     */
    Product findById(Long id);
}
