package com.ars.demo.service.Impl;

import com.ars.demo.dao.GoodsDao;
import com.ars.demo.domain.Goods;
import com.ars.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    //@Transactional
    public List<Goods> getGoodsList() {
        return goodsDao.getGoodsList();
    }

    @Override
    public void saveGoods(Goods goods) {
        goodsDao.saveGoods(goods);
    }

    @Override
    public void edit(Goods goods) {
        goodsDao.editGoods(goods);
    }

}