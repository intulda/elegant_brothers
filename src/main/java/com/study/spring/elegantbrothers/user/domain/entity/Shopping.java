package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "SHOPPING", uniqueConstraints = {@UniqueConstraint(name="PK_SHOPPING" , columnNames = {"GOODS_ID"})})
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_ID", length = 20, nullable = false)
    private long goodsId;                         // 상품ID

    @Column(name = "CSTMR_ID", length = 20, nullable = false)
    private String cstmrId;                       // 고객ID

    @Column(name = "GOODS_ORDER_REPR", length = 7)
    private int goodsOrderRepr;                   // 상품주문개수

    @Embedded
    private Log log;
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GOODS_ID", nullable = true)
    private ShoppingMaster shoppingMaster;
    */
    @Builder
    public Shopping( long goodsId, String cstmrId, int goodsOrderRepr, Log log) {

        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");
        Assert.hasText(cstmrId, "cstmrId must not be empty");
        this.goodsId = goodsId;
        this.cstmrId = cstmrId;
        this.goodsOrderRepr = goodsOrderRepr;
        this.log = log;
    }
}
