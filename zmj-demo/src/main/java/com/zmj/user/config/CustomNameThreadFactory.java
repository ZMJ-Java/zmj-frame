package com.zmj.user.config;


import org.apache.commons.lang.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZMJ
 * @Package com.zmj.user.config
 * @date 2023/10/23 15:57
 */
public class CustomNameThreadFactory implements ThreadFactory {


    private final AtomicInteger poolNumber = new AtomicInteger(1);

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final ThreadGroup group;

    private final String namePrefix;


    public CustomNameThreadFactory(String name) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (StringUtils.isBlank(name)) {
            name = "pool";
        }
        namePrefix = name +
                poolNumber.getAndIncrement() +
                "-thread-";

    }

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement());

        if (thread.isDaemon()){
            thread.setDaemon(false);
        }

        if (thread.getPriority() != Thread.NORM_PRIORITY){
            thread.setPriority(Thread.NORM_PRIORITY);
        }

        return thread;
    }
}
