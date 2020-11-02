package com.cloudshop.common;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1498446706544212015L;

    private Long id;
    private String title;
    private Integer price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
