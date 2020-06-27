package com.shuimutong.learn.basestart.dao;

import com.shuimutong.learn.basestart.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
