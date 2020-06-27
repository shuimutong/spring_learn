package com.shuimutong.learn.basestart.controller;

import com.shuimutong.learn.basestart.dao.UserRepository;
import com.shuimutong.learn.basestart.domain.User;
import com.shuimutong.learn.basestart.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(path="/add")
    @ResponseBody
    public User addUser(@RequestParam String name, @RequestParam Integer age) {
        User user = new User();
        if(StringUtils.isBlank(name) || age == null) {
            System.out.println("参数异常");
            return null;
        }
        user.setName(name);
        user.setAge(age);
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @GetMapping(path="listAll")
    @ResponseBody
    public Iterable<User> listAllUser() {
        return userRepository.findAll();
    }

    @GetMapping(path="testTrans")
    @ResponseBody
    public int testTransaction(@RequestParam String userIds) {
        List<Long> userIdList = Arrays.stream((userIds.split(","))).map(str -> Long.parseLong(str)).collect(Collectors.toList());
        userService.batchUpdate(userIdList);
        return userIdList.size();
    }

    @GetMapping(path="update")
    @ResponseBody
    public User update(@RequestParam long userId) {
        User user = userService.update(userId);
        return user;
    }

    @GetMapping(path="updateTwo")
    @ResponseBody
    public User updateTwo(@RequestParam long userId,@RequestParam int userError,
                          @RequestParam int objError) {
        User user = userService.updateAndCache(userId, userError, objError);
        return user;
    }
}
