package com.zmj.redis.cache;

import com.zmj.redis.init.AbstractCache;
import com.zmj.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.redis.cache
 * @date 2023/10/16 8:27
 */
@Component
public class SysUserCache extends AbstractCache {

    private static final String SYS_USER_CACHE_KEY = "SYS_USER";

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        //跟数据库联动，或者其他数据源联动
        redisUtil.set("age","18");
    }

    @Override
    public <T> T getCache(String key) {
        if (!redisTemplate.hasKey(key).booleanValue()){
            reloadCache();
        }

        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(SYS_USER_CACHE_KEY);
    }


}
