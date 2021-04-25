package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "ATTENTION")
public class Attention {

    @Id
    @Column(name = "CSTMR_ID", length = 20)
    private String cstmrId;                       // 고객ID

    @Column(name = "GOODS_ID", length = 20, nullable = false)
    private long goodsId;                     // 상품ID
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CSTMR_ID", nullable = true)
    private AttentionMaster attentionMaster;
    */
    @Embedded
    private Log log;

    public Attention(String cstmrId, long goodsId, Log log ) {

        Assert.hasText(cstmrId, "cstmrId must not be empty");
        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");

        this.cstmrId = cstmrId;
        this.goodsId = goodsId;
        this.log = log;

    }
}
