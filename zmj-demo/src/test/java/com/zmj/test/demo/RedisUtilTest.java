package com.zmj.test.demo;

import com.zmj.redis.util.RedisUtil;
import com.zmj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/23 21:50
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class RedisUtilTest {

    @Resource
    private RedisUtil redisUtil;


    @Test
    public void test() {
        Boolean result = redisUtil.compareAndSet("luaCas", 2L, 3L);
        log.info("com.zmj.test.demo.RedisUtilTest result:{}",result);
    }
}
