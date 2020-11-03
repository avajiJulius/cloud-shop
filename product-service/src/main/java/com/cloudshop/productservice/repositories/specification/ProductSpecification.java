package com.cloudshop.productservice.repositories.specification;

import com.cloudshop.productservice.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import java.time.LocalDate;


public class ProductSpecification {
    public static Specification<Product> titleContains(String word) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Product> priceGreaterThanOrEqualTo(double value) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value);
    }

    public static Specification<Product> priceLesserThanOrEqualTo(double value) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), value);
    }

 }
