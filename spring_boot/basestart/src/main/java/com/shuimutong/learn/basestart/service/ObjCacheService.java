package com.shuimutong.learn.basestart.service;

import com.shuimutong.learn.basestart.domain.ObjCache;

public interface ObjCacheService {
    void save(ObjCache objCache, boolean error);

    ObjCache findById(long id);

    ObjCache findByObjId(String objId);
}
