package com.ars.demo.domain;

import lombok.Data;

@Data
public class User {

    private long id;
    private String nickName;
    private String userName;
    private int userType;
    private int delete;

}
