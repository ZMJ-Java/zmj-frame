package com.zmj.user.controller;

import com.zmj.bean.Result;
import com.zmj.redis.util.RedisUtil;
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
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

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


}
