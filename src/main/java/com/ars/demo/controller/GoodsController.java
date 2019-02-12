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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //返回页面的JSON
        Map result = new HashMap();
        try {
            //获取数据
            List<Goods> goodsList = goodsService.getGoodsList();
            result.put("data", goodsList);
            result.put("state", "success");
        } catch (Exception e){
            result.put("state", "error");
        }
        return JSON.toJSONString(result);
    }

    @PostMapping(value = "/add")
    public String add(Goods goods){
        //传参（key，是否必传）变量类型 变量名
        //@RequestParam(value = "testParam",required = false) String test
        goodsService.saveGoods(goods);
        return "\"data\":" + goods.getId();
    }

    @PostMapping(value = "/edit")
    public String edit(Goods goods){
        goodsService.edit(goods);
        return "\"success\"";
    }

}
