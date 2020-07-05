package com.shuimutong.learn.mybatis.service.impl;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.mybatis.dao.User3Mapper;
import com.shuimutong.learn.mybatis.domain.User;
import com.shuimutong.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User3Mapper user3Mapper;

    @Override
    public User findById(long id) {
        System.out.println("user3MapperIsNull?");
        System.out.println(JSON.toJSONString(user3Mapper));
        return user3Mapper.selectUser(id);
    }
}
