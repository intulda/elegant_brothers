package com.study.spring.elegantbrothers.product.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImages {

    @Id @GeneratedValue
    @Column(name = "GOODS_FILE_ID")
    private Long id;

    @Column(name = "GOODS_FILE_ADDRESS")
    private String fileAddress;

    @Embedded
    private Log log;

    @Builder
    public ProductImages(String fileAddress, Log log) {
        this.fileAddress = fileAddress;
        this.log = log;
    }
}
