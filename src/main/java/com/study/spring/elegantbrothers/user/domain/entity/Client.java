package com.study.spring.elegantbrothers.user.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTS")
public class Client extends User {

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID")
    private Long id;
}
