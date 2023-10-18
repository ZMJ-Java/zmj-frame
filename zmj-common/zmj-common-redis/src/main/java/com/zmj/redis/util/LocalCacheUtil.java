package com.zmj.redis.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author ZMJ
 * @Package com.zmj.redis.util
 * @describe 本地缓存工具类
 * @date 2023/10/17 20:27
 */
@Component
@Slf4j
public class LocalCacheUtil<K, V> {

    @Value("${guava.cache.switch}")
    public Boolean switchCache;

    //初始化本地缓存
    private Cache<String, String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .build();

    public Map<K, V> getResult(List<K> skuIdList, String cachePrefix,
                               Class<V> clazz, Function<List<K>, Map<K, V>> function) {

        //参数校验
        if (CollectionUtils.isEmpty(skuIdList)) {
            return Collections.emptyMap();
        }

        //声明结果
        Map<K, V> resultMap = new HashMap<>(16);

        //判断开关
        if (!switchCache) {
            resultMap = function.apply(skuIdList);
            return resultMap;
        }

        //声明本地没有的list
        List<K> notinLocalCacheList = new ArrayList<>();

        //开始遍历
        for (K id : notinLocalCacheList) {
            String cacheKey = cachePrefix + "_" + id;
            String content = localCache.getIfPresent(cacheKey);
            if (StringUtils.isNotBlank(content)) {
                V v = JSON.parseObject(content, clazz);
                resultMap.put(id, v);
            } else {
                notinLocalCacheList.add(id);
            }
        }

        if (CollectionUtils.isEmpty(notinLocalCacheList)) {
            return resultMap;
        }

        Map<K, V> notinLocalCacheResultMap = function.apply(notinLocalCacheList);

        if (notinLocalCacheResultMap == null || notinLocalCacheResultMap.isEmpty()) {
            return resultMap;
        }

        for (Map.Entry<K, V> entry : notinLocalCacheResultMap.entrySet()) {
            K id = entry.getKey();
            V result = entry.getValue();
            resultMap.put(id, result);
            String cacheKey = cachePrefix + "_" + id;
            localCache.put(cacheKey, JSON.toJSONString(result));
        }

        return resultMap;
    }

}
