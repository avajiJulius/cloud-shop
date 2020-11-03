package com.cloudshop.productservice.controllers;

import com.cloudshop.productservice.entities.Product;
import com.cloudshop.productservice.repositories.specification.ProductSpecification;
import com.cloudshop.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductControllerImpl implements ProductController{

    private static final Integer INITIAL_PAGE = 0;
    private static final Integer PAGE_SIZE = 10;

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



    @Override
    public List<Product> searchProductsWithPagingAndFilter(Model model,
                                                           @RequestParam(name = "page") Optional<Integer> page,
                                                           @RequestParam(name = "title", required = false) String title,
                                                           @RequestParam(name = "min", required = false) Double minPrice,
                                                           @RequestParam(name = "max", required = false) Double maxPrice) {
        final int currentPage = (page.orElse(0) < 1 ) ? INITIAL_PAGE : page.get() - 1;

        Specification<Product> spec = Specification.where(null);
        StringBuffer filter = new StringBuffer();
        if (title != null) {
            spec = spec.and(ProductSpecification.titleContains(title));
            filter.append("&word=" + title);
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterThanOrEqualTo(minPrice));
            filter.append("&min=" + title);
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLesserThanOrEqualTo(maxPrice));
            filter.append("&max=" + title);
        }

        Page<Product> products = service.getProductWithPagingAndFiltering(INITIAL_PAGE, PAGE_SIZE, spec);

        List<Product> result = products.getContent();
        model.addAttribute("products", result);
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("filters", products.toString());
        model.addAttribute("title", title);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);

        return result;
    }

    @Override
    public String createProduct(Product product) {
        Product p = service.createOrUpdate(product);

        return "Product successful created. Your product ID is " + p.getProductId();
    }

    @Override
    public String updateProduct(Product product) {
        service.createOrUpdate(product);
        return "Product successful updated!";
    }


    @Override
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "Success delete";
    }


}
