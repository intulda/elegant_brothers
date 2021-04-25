package com.study.spring.elegantbrothers.product.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODCUT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODCUT_PRICE")
    private int price;

    @Embedded
    private Log log;
}
