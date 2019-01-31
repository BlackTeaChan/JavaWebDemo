package com.ars.demo.dao;

import com.ars.demo.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select * from goods_info")
    List<Goods> getGoodsList();

    /**
     * option注解标签
     * useGeneratedKeys=true 表示使用数据库自动增长的主键
     * keyColumn 用于指定数据库table中的主键
     * keyProperty 用于指定传入对象的成员变量
     */
    @Options(useGeneratedKeys = true, keyProperty = "Goods.id", keyColumn = "id")
    @Insert("insert into goods_info(goods_code, goods_name, create_user, create_time, is_delete) values(#{Goods.goodsCode},#{Goods.goodsName},null,now(),0);")
    void saveGoods(@Param("Goods") Goods goods);

    @Update("update from goods_info (goods_code = #{Goods.goodsCode}, goods_name = #{Goods.goodsName}, is_delete = #{Goods.isDelete}) where id = #{Goods.id}")
    void editGoods(@Param("Goods") Goods goods);
}
