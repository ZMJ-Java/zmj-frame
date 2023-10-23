package com.zmj.test.demo;

import com.zmj.tool.CompletableFutureUtils;
import com.zmj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    public void test() {
        for (int i = 0; i < 10; i++) {
            mailThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    log.info("当前时间：" + System.currentTimeMillis());
                }
            });
        }
    }

    @Test
    public void testFuture() {
        List<Future<String>> futureTaskList = new ArrayList<>();


        FutureTask<String> stringFutureTask1 = new FutureTask<String>(() -> {
            Thread.sleep(2000);
            return "ZMJ";
        });

        FutureTask<String> stringFutureTask2 = new FutureTask<String>(() -> {
            return "MZD";
        });

        futureTaskList.add(stringFutureTask1);
        futureTaskList.add(stringFutureTask2);

        mailThreadPool.submit(stringFutureTask1);
        mailThreadPool.submit(stringFutureTask2);


        for (int i = 0; i < futureTaskList.size(); i++) {
            String name = CompletableFutureUtils.getResult(futureTaskList.get(i), 1L, TimeUnit.SECONDS, "666", log);
            log.info("testFuture:{}", name);
        }
    }

}
