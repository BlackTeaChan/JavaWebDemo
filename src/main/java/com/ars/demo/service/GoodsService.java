package com.ars.demo.service;

import com.ars.demo.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getGoodsList();

    void saveGoods(Goods goods);

    void edit(Goods goods);
}
