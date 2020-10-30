package com.cloudshop.productservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Integer price;
    @Column(name = "on_create")
    private LocalDate createDate;
    @Column(name = "on_update")
    private LocalDate updateDate;
    @Column(name = "enabled")
    private boolean isEnable;

}