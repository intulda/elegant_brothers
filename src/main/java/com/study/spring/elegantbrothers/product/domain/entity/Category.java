package com.study.spring.elegantbrothers.product.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Category {

    @Id @GeneratedValue
    @Column(name = "GOODS_ID")
    private Long id;

    @Column(name = "GOODS_CATEGORY_NAME")
    private String name;

    @Embedded
    private Log log;

    @Builder
    public Category(String name, Log log) {
        this.name = name;
        this.log = log;
    }
}
