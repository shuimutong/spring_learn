package com.shuimutong.learn.basestart.service.impl;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.basestart.dao.UserRepository;
import com.shuimutong.learn.basestart.domain.ObjCache;
import com.shuimutong.learn.basestart.domain.User;
import com.shuimutong.learn.basestart.service.ObjCacheService;
import com.shuimutong.learn.basestart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjCacheService objCacheService;

    int num = 1;

    @Override
    @Transactional
    public User updateAndCache(long userId, int userError, int objError) {
        System.out.println("UserServiceupdate---,userId:" + userId + ",objError:" + objError);
        Optional<User> userOpt = userRepository.findById(userId);
        User user = userOpt.get();
        System.out.println("UserService更新前，user" + JSON.toJSONString(user));
        num++;
        System.out.println("num:" + num);
        user.setAge(num);
        System.out.println("UserService准备更新，user" + JSON.toJSONString(user));
        userRepository.save(user);
        userOpt = userRepository.findById(userId);
        user = userOpt.get();
        System.out.println("UserService更新后，user" + JSON.toJSONString(user));

        ObjCache objCache = objCacheService.findByObjId(userId + "");
        System.out.println("UserService更新前objCache:" + JSON.toJSONString(objCache));
        if(objCache == null) {
            objCache = new ObjCache();
        }
        objCache.setObjId(user.getId() + "");
        objCache.setContent(JSON.toJSONString(user));
        objCache.setParentObjId("");
        System.out.println("UserService准备存储objCache:" + JSON.toJSONString(objCache));
        try {
            objCacheService.save(objCache, objError == 1);
        } catch (Exception e) {
            System.out.println("UserService保存objCache异常");
        }
        objCache = objCacheService.findByObjId(userId + "");
        System.out.println("UserService更新后objCache:" + JSON.toJSONString(objCache));
        if(userError == 1) {
            throw new RuntimeException("saveUserError");
        }
        return user;
    }

    @Override
    @Transactional
    public User update(long id) {
        System.out.println("update---,id:" + id);
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();
        System.out.println("更新前，user" + JSON.toJSONString(user));
        try {
            realUpdaate(user);
            System.out.println("无异常---");
        } catch (Exception e) {
            System.out.println("有异常***");
            throw e;
        }
        userOpt = userRepository.findById(id);
        user = userOpt.get();
        System.out.println("更新后，user" + JSON.toJSONString(user));
        return user;
    }

    public void realUpdaate(User user) {
        num++;
        System.out.println("num:" + num);
        user.setAge(num);
        userRepository.save(user);
        if(num % 2 == 0) {
            throw new RuntimeException("testTrans");
        }
    }

    Random r = new Random();

    @Transactional
    @Override
    public void batchUpdate(List<Long> userIdList) {
        int num = r.nextInt();
        Iterable<User> users = userRepository.findAllById(userIdList);
        System.out.println("批量更新，users:" + JSON.toJSONString(users));
        for(User u : users) {
            u.setName("trans" + num);
            User savedUser = userRepository.save(u);
            System.out.println(JSON.toJSONString(savedUser));
        }
        Iterable<User> reFindUsers = userRepository.findAll();
        System.out.println("再次查询用户");
        System.out.println(JSON.toJSONString(reFindUsers));
        System.out.println("等待10s");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(num % 2 == 1) {
            throw new RuntimeException("test");
        }
    }
}
