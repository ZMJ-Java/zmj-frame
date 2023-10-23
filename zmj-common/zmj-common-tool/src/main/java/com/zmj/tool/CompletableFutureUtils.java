package com.zmj.tool;


import org.slf4j.Logger;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @date 2023/10/23 16:45
 */
public class CompletableFutureUtils {
    //defaultValue 线程超时会返回默认值defaultValue
    public static <T> T getResult(Future<T> future, long timeOut, TimeUnit timeUnit, T defaultValue, Logger logger) {
        try {
            return future.get(timeOut, timeUnit);
        } catch (Exception e) {
            logger.error("{}", e.getMessage(), e);
        }

        return defaultValue;
    }
}
