package com.study.spring.elegantbrothers.order.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "ORDER", uniqueConstraints = {@UniqueConstraint(name="PK_ORDER" , columnNames = {"ORDER_ID", "GOODS_ID"})})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", length = 20 )
    private long orderId;                     // 주문ID

    @Column(name="CSTMR_ID", length = 20, nullable = false)
    private String cstmrId;                       // 고객ID

    @Column(name="GOODS_ID", length = 20)
    private long goodsId;                     // 상품ID

    @Column(name="GOODS_ORDER_REPR", length = 7)
    private int goodsOrderPepr;              // 상품주문개수
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private OrderMaster orderMaster;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Payment payment;
*/
    @Embedded
    private Log log;

    @Builder
    public Order(long orderId, String cstmrId, long goodsId, int goodsOrderPepr, String goodsPc, String goodsName, Log log) {
        Assert.hasText(String.valueOf(orderId), "orderId must not be empty");
        Assert.hasText(cstmrId, "cstmrId must not be empty");
        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");

        this.orderId = orderId;
        this.cstmrId = cstmrId;
        this.goodsId = goodsId;
        this.goodsOrderPepr = goodsOrderPepr;
        this.log = log;
    }
}
