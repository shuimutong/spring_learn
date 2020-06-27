package com.shuimutong.learn.basestart.service;

import com.shuimutong.learn.basestart.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    User updateAndCache(long userId, int userError, int objError);

    User update(long id);

    void batchUpdate(List<Long> userIdList);
}
