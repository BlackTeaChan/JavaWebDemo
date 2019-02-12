package com.ars.demo.service.Impl;

import com.ars.demo.dao.UserDao;
import com.ars.demo.domain.User;
import com.ars.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList(String s) {
        return userDao.getUserList(s);
    }

}
