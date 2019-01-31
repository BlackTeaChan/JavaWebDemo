package com.ars.demo.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class User {

    private BigInteger id;
    private String nickName;
    private String userName;
    private int userType;

}
