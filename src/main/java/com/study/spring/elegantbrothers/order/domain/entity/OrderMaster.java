package com.study.spring.elegantbrothers.order.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "ORDER_MASTER", uniqueConstraints = {@UniqueConstraint(name="PK_ORDER_MASTER" , columnNames = {"ORDER_ID"})})
public class OrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", length = 20)
    private long orderId;                       // 주문 ID

    @Column(name = "CSTMR_ID", length = 20)
    private String cstmrId;                     // 고객 ID

    @Column(name = "GOODS_ORDER_REPR", length = 7)
    private int goodsOrderRepr;              // 상품주문개수

    @Column(name = "GOODS_LIKE", length = 10)
    private int goodsLike;                   // 상품좋아요

    @Column(name = "GOODS_DC", length = 2000)
    private String goodsDc;                     // 상품설명

    @Embedded
    private Log log;
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ORDER_ID")
    private List<Order> orders = new ArrayList<>();
    */
    public OrderMaster(long orderId, String cstmrId, int goodsOrderRepr, int goodsLike, String goodsDc, Log log) {
        Assert.hasText(String.valueOf(orderId), "orderId must not be empty");
        this.orderId = orderId;
        this.cstmrId = cstmrId;
        this.goodsOrderRepr = goodsOrderRepr;
        this.goodsLike = goodsLike;
        this.goodsDc = goodsDc;
        this.log = log;
    }

}
