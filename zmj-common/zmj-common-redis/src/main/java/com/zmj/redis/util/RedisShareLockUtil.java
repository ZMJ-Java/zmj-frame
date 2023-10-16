package com.zmj.redis.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zmj.redis.exception.ShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ZMJ
 * @Package com.zmj.redis.util
 * @date 2023/10/16 14:04
 * @describe Redis分布式抢占锁RedisShareLockUtil
 */
@Component
public class RedisShareLockUtil {

    @Autowired
    private RedisUtil redisUtil;

    private Long TIME_OUT = 1000L;


    /**
     * 加锁
     */
    public boolean lock(String lockKey, String requestId, Long time) {
        //1、参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁-参数异常");
        }
        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        Boolean result = false;

        //2、加锁可以有自旋
        while (currentTime < outTime) {
            //3、借助redis的setnx进行锁的设置
            result = redisUtil.setnx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            //set expire（保证原子性）
            if (result) {
                return result;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * 解锁
     */
    public boolean unlock(String key, String requestId) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId)) {
            throw new ShareLockException("分布式锁-解锁-参数异常");
        }
        try {
            String value = redisUtil.get(key);

            if (requestId.equals(value)) {
                boolean del = redisUtil.delete(key);
            }

        } catch (Exception e) {
            //补日志
        }
        return false;
    }

    /**
     * 尝试锁
     */
    public boolean tryLock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-尝试加锁-参数异常");
        }
        return redisUtil.setnx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }

}



