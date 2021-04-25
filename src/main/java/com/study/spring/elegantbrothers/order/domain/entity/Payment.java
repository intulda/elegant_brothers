package com.study.spring.elegantbrothers.order.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Address;
import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "PAYMENT", uniqueConstraints = {@UniqueConstraint(name="PK_PAYMENT" , columnNames = {"DLVR_SETLE_NO"})})
public class Payment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DLVR_SETLE_NO", length = 20)
    private long dlvrSetleNo;       // 배달결제번호

    @Column(name = "ORDER_ID", length = 20, nullable = false)
    private long orderId;         // 주문ID

    @Column(name="GOODS_ID", length = 20, nullable = false)
    private long goodsId;                     // 상품ID

    @Column(name = "DLVR_TLPHON_NO", length = 20)
    private String dlvrTlphonNo;    // 배달전화번호

    @Embedded
    private Address address;

    @Embedded
    private Log log;
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ORDER_ID")
    private List<Order> orders = new ArrayList<>();
    */
    @Builder
    public Payment(long dlvrSetleNo, long orderId, long goodsId, String dlvrTlphonNo, Address address, Log log) {

        Assert.hasText(String.valueOf(dlvrSetleNo), "dlvrSetleNo must not be empty");
        Assert.hasText(String.valueOf(orderId), "orderId must not be empty");
        Assert.hasText(String.valueOf(goodsId), "orderId must not be empty");
        this.dlvrSetleNo = dlvrSetleNo;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.dlvrTlphonNo = dlvrTlphonNo;
        this.address = address;
        this.log = log;

    }
}


