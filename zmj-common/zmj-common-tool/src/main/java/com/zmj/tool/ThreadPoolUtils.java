package com.zmj.tool;

import com.hp.hpl.sparta.Sparta;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @date 2023/10/24 14:40
 */
@Slf4j
public class ThreadPoolUtils {

    private ThreadPoolUtils() {
    }


    public static void shutDownPool(ExecutorService pool, int shutDownTimeout
            , int shutDownNowTimeout, TimeUnit timeUnit) {

        try {
            if (!pool.awaitTermination(shutDownTimeout, timeUnit)) {
                pool.shutdown();
                if (!pool.awaitTermination(shutDownNowTimeout, timeUnit)) {
                    log.error("ThreadPoolUtils.shuDownPool.error");
                }
            }
        } catch (InterruptedException e) {
            log.error("ThreadPoolUtils.shutDownPool.interrupt.error:{}", e.getMessage(), e);
            pool.shutdownNow();
            Thread.currentThread().interrupt();

        }
    }

}
