package com.shuimutong.learn.basestart.service.impl;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.basestart.dao.ObjCacheRepository;
import com.shuimutong.learn.basestart.domain.ObjCache;
import com.shuimutong.learn.basestart.service.ObjCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ObjCacheServiceImpl implements ObjCacheService {
    @Autowired
    private ObjCacheRepository objCacheRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void save(ObjCache objCache, boolean error) {
        System.out.println("ObjCacheService准备更新,objCache:" + JSON.toJSONString(objCache));
        objCacheRepository.save(objCache);
        if(error) {
            throw new RuntimeException("objCacheError");
        }
        ObjCache savedObjCache = findByObjId(objCache.getObjId());
        System.out.println("ObjCacheService更新后,objCache:" + JSON.toJSONString(savedObjCache));
    }

    @Override
    public ObjCache findById(long id) {
        return objCacheRepository.findById(id).get();
    }

    @Override
    public ObjCache findByObjId(String objId) {
        String sql = "select id, obj_id, content from obj_cache where obj_id=?";
        List<ObjCache> list = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<ObjCache>(ObjCache.class), objId);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
