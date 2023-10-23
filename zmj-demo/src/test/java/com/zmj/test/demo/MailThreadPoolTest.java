package com.zmj.test.demo;

import com.alibaba.fastjson.JSON;
import com.zmj.redis.delayQueue.MassMailTask;
import com.zmj.redis.delayQueue.MassMailTaskService;
import com.zmj.redis.util.RedisShareLockUtil;
import com.zmj.tool.CompletableFutureUtils;
import com.zmj.tool.SimpleDateFormatUtils;
import com.zmj.user.UserApplication;
import com.zmj.user.event.Person;
import com.zmj.user.event.PersonEventService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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

    @Resource
    private PersonEventService personEventService;

    @Resource
    private MassMailTaskService massMailTaskService;

    @Resource
    private RedisShareLockUtil redisShareLockUtil;


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


    @Test
    public void publishEvent() {
        Person person = new Person();
        person.setName("zmj");
        person.setAge(12);
        personEventService.executePerson(person);
    }


    @Test
    public void publishTask() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        MassMailTask massMailTask = new MassMailTask();

        massMailTask.setTaskId(1L);
        massMailTask.setStartTime(simpleDateFormat.parse("2023-10-23 20:06:00"));

        massMailTaskService.pushMassMailTaskQueue(massMailTask);
    }

    @Test
    public void deal() throws ParseException {

        String lockKey = "test.delay.task";
        String requestId = UUID.randomUUID().toString();

        try {
            boolean lock = redisShareLockUtil.lock(lockKey, requestId, 5L);

            if (!lock){
                return;
            }
            Set<Long> longs = massMailTaskService.poolMassTaskQueue();
            log.info("定时任务拉取：{}",JSON.toJSONString(longs));

        } catch (Exception e) {

            log.error("拉取异常：{}",e.getMessage());
        }finally {
            redisShareLockUtil.unlock(lockKey,requestId);
        }
    }

}
