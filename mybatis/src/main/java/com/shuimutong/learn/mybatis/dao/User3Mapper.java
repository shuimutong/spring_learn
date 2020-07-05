package com.shuimutong.learn.mybatis.dao;

import com.shuimutong.learn.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface User3Mapper {
    User selectUser(long id);
}
