package com.zmj.redis.cache;

import com.zmj.redis.init.AbstractCache;
import com.zmj.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.redis.cache
 * @date 2023/10/16 8:34
 */
@Component
public class CategoryCache extends AbstractCache {

    public static final String CATEGORY_CACHE = "CATEGORY_CACHE";


    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        //更数据库联动
        redisUtil.set("知识","理解");
    }

    @Override
    public <T> T getCache(String key) {
        if (!redisTemplate.hasKey(key).booleanValue()){
            clearCache();
        }

        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(CATEGORY_CACHE);
    }
}
