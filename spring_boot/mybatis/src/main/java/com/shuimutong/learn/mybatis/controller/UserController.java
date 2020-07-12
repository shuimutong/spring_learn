package com.shuimutong.learn.mybatis.controller;

import com.shuimutong.learn.mybatis.domain.User;
import com.shuimutong.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(long id) {
        return userService.findById(id);
    }
}
