package com.zmj.user.controller;

import com.zmj.bean.Result;
import com.zmj.redis.util.RedisShareLockUtil;
import com.zmj.redis.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ZMJ
 * @Package com.zmj.user.controller
 * @date 2023/10/11 10:07
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "hello world";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testRedis")
    public Result testRedis() {
//        redisTemplate.opsForValue().set("日期","10_13");
        String str = (String) redisTemplate.opsForValue().get("日期");
        String string = redisUtil.get("日期");
        System.out.println(redisTemplate.opsForValue().get("日期").getClass());
        System.out.println(str);
        return Result.ok(string);
//        redisTemplate.opsForHash().put();
//        redisTemplate.opsForSet()
//        redisTemplate.opsForZSet()

    }

    @RequestMapping(method = RequestMethod.GET, value = "/testRedisLock")
    public Boolean testRedisLock() {

        boolean result = redisShareLockUtil.lock("zmj", "12434", 10000L);
        System.out.println(result);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testLog")
    public void testLog() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            logger.info("这个是第{}日志", i);
        }
        long endTime = System.currentTimeMillis();
        logger.info("当前日志花费时间: {}s", endTime - startTime);
    }


}
