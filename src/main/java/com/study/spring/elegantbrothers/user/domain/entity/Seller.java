package com.study.spring.elegantbrothers.user.domain.entity;

import javax.persistence.*;

@Entity
public class Seller extends User {

    @Id
    @GeneratedValue
    @Column(name = "SELLER_ID")
    private Long id;


}
