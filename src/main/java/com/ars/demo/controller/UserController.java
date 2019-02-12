package com.ars.demo.controller;

import com.alibaba.fastjson.JSON;
import com.ars.demo.domain.User;
import com.ars.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public String list(@RequestParam(value="searchText", required=false)String searchText){
        Map result = new HashMap();
        try {
            if(searchText==null){
                searchText = "";
            }
            List<User> userList = userService.getUserList(searchText);
            result.put("data", userList);
            result.put("state", "success");
        } catch (Exception e){
            result.put("state", "error");
        }
        return JSON.toJSONString(result);
    }

}
