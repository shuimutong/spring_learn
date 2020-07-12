package com.shuimutong.learn.mybatis.dao;

import com.shuimutong.learn.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User3Mapper {
    User selectUser(long id);
}
