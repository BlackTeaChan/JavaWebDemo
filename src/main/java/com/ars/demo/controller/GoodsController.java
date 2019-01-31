package com.ars.demo.controller;

import com.alibaba.fastjson.JSON;
import com.ars.demo.domain.Goods;
import com.ars.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/index")
    public String index(){
        return "goods/list";
    }

    @PostMapping(value="/list")
    public String list(){
        List<Goods> list = goodsService.getGoodsList();
        String sGoodsJson = JSON.toJSONString(list);
        return "data:" + sGoodsJson;
    }

    @PostMapping(value = "/add")
    public String add(Goods goods){
        goodsService.saveGoods(goods);
        return "data:" + goods.getId();
    }

    @PostMapping(value = "/edit")
    public String edit(Goods goods){
        goodsService.edit(goods);
        return "success";
    }

}
