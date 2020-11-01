package com.cloudshop.productservice.repositories.specification;

import com.cloudshop.productservice.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;


public class ProductSpecification {
    public static Specification<Product> titleContains(String word) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Product> priceGreaterThanOrEqualTo(int value) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value);
    }

    public static Specification<Product> priceLesserThanOrEqualTo(int value) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), value);
    }

    public static Specification<Product> dateBeforeOrEqualTo(LocalDate date) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("on_update"), date);
    }

    public static Specification<Product> dateAfterOrEqualTo(LocalDate date) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("on_update"), date);
    }
 }
