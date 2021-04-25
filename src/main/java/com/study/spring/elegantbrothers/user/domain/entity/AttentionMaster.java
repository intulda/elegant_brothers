package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "ATTENTION_MASTER")
public class AttentionMaster {
    @Id
    @Column(name = "CSTMR_ID", length = 20)
    private String cstmrId;                       // 고객ID

    @Column(name = "GOODS_ID", length = 20, nullable = false)
    private long goodsId;                     // 상품ID

    @Column(name = "GOODS_LIKE", length = 10)
    private int goodsLike;                      // 상품좋아요

    @Column(name = "GOODS_DC", length = 2000)
    private String goodsDc;                     // 상품 설명

    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "CSTMR_ID")
    private List<Attention> attentions = new ArrayList<>();
    */
    @Embedded
    private Log log;

    @Builder
    public AttentionMaster( String cstmrId, long goodsId, int goodsLike, String goodsDc, Log log) {
        Assert.hasText(cstmrId, "cstmrId must not be empty");
        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");
        this.cstmrId = cstmrId;
        this.goodsId = goodsId;
        this.goodsLike = goodsLike;
        this.goodsDc = goodsDc;
        this.log = log;
    }
}
