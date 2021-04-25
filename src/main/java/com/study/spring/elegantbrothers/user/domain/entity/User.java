package com.study.spring.elegantbrothers.user.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Address;
import com.study.spring.elegantbrothers.common.domain.embed.Log;
import com.study.spring.elegantbrothers.user.domain.enums.UserStatus;

import javax.persistence.*;

@Entity
@Table(name = "USER_MASTER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_MASTER_ID")
    private Long id;

    @Column(name = "GRADE_CODE")
    private String gradeCode;

    @Column(name = "ACCOUNT_ID")
    private String account;

    @Column(name = "ACCOUNT_PASSWORD")
    private String password;

    @Column(name = "ACCOUNT_NAME")
    private String name;

    @Column(name = "ACCOUNT_EMAIL")
    private String email;

    @Column(name = "ACCOUNT_BIRTHDAY")
    private String birthday;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Embedded
    private Address address;

    @Embedded
    private Log log;
}