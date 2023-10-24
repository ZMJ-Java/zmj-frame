package com.zmj.test.demo;

import com.zmj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/24 14:23
 */
@SpringBootTest(classes = UserApplication.class ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ThreadPoolShutDownTest {

    @Test
    public void testShutDown() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new TaskShutDownPool());
        }
        Thread.sleep(1000);

        log.info("testShutDown.status:{},before",executorService.isShutdown());

        List<Runnable> runnables = executorService.shutdownNow();

        log.info("testShutDown.status:{},after",executorService.isShutdown());

        Thread.sleep(500);

        log.info("testShutDown.down");

        executorService.execute(new TaskShutDownPool());

    }


    @Test
    public void testShutDown2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new TaskShutDownPool());
        }
        Thread.sleep(1000);

        log.info("testShutDown.status:{},before",executorService.isTerminated());

        executorService.shutdown();

        log.info("testShutDown.status:{},after",executorService.isTerminated());

        Thread.sleep(500);

        log.info("testShutDown.down");

        executorService.execute(new TaskShutDownPool());

    }

    class TaskShutDownPool implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(500);

                log.info("TaskShutDownPool： {}",Thread.currentThread().getName());

            }catch (InterruptedException e){
                log.error("shut down",e);
            }
        }
    }
}
