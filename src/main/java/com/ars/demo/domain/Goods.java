package com.ars.demo.domain;

import lombok.Data;

@Data
public class Goods {

    private long id;
    private String goodsName;
    private String goodsCode;
    private long createUser;
    private String updateUser;
    private int isDelete = 0;

}
