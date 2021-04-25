package com.study.spring.elegantbrothers.product.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_DETAIL_ID")
    private Long id;

    @Column(name = "GOODS_DESCRIPTION")
    private String description;

    @Embedded
    private Log log;

    @Builder
    public ProductDetail(String description, Log log) {
        this.description = description;
        this.log = log;
    }
}
