package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "SHOPPING_MASTER")
public class ShoppingMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "GOODS_ID", length = 20, nullable = false)
    private long goodsId;                         // 상품ID

    @Column(name = "CSTMR_ID", length = 20, nullable = false)
    private String cstmrId;                       // 고객ID

    @Column(name = "GOODS_ORDER_REPR", length = 7)
    private int goodsOrderRepr;                   // 상품주문개수

    @Column(name = "GOODS_LIKE", length = 10)
    private int goodsLike;                        // 상품 좋아요

    @Column(name = "GOODS_DC", length = 2000, nullable = false)
    private String goodsDc;                     // 상품 설명

    @Embedded
    private Log log;
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "GOODS_ID")
    private List<Shopping> shopping = new ArrayList<>();
    */
    @Builder
    public ShoppingMaster( long goodsId, String cstmrId, int goodsOrderRepr, int goodsLike, String goodsDc, Log log) {

        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");
        Assert.hasText(cstmrId, "cstmrId must not be empty");
        this.goodsId = goodsId;
        this.cstmrId = cstmrId;
        this.goodsOrderRepr = goodsOrderRepr;
        this.goodsLike = goodsLike;
        this.goodsDc = goodsDc;
        this.log = log;
    }
}
