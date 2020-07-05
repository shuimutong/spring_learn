package com.shuimutong.learn.mybatis.service;

import com.shuimutong.learn.mybatis.domain.User;

public interface UserService {
    User findById(long id);
}
