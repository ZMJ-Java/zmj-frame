package com.zmj.test.demo;

import com.zmj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/23 15:52
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class MailThreadPoolTest {

    @Resource(name = "mailThreadPool")
    private ThreadPoolExecutor mailThreadPool;


    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            mailThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    log.info("当前时间：" + System.currentTimeMillis());
                }
            });
        }
    }
}
