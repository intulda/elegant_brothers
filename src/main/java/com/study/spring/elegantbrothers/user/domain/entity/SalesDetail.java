package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import com.study.spring.elegantbrothers.product.domain.entity.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "SALES_DETAIL")
public class SalesDetail {

    @Id @GeneratedValue
    @Column(name = "SALES_ID")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> products;

    @Embedded
    private Log log;

    @Builder
    public SalesDetail(List<Product> products, Log log) {
        this.products = products;
        this.log = log;
    }
}
