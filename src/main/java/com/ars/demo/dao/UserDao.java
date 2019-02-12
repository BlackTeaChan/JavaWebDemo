package com.ars.demo.dao;

import com.ars.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("<script>" +
            "select * from user_info where 1=1" +
            "<if test='S!=null'>" +
            "and (id like '%${S}%' or nickname like '%${S}%' or username like '%${S}%')" +
            "</if>" +
            "</script>")
    List<User> getUserList(@Param("S") String s);

}
