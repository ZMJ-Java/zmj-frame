package com.zmj.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZMJ
 * @Package com.zmj.user.config
 * @date 2023/10/23 15:46
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "mailThreadPool")
    public ThreadPoolExecutor getMailThreadPool() {

        CustomNameThreadFactory mail = new CustomNameThreadFactory("mail");

        return new ThreadPoolExecutor(20, 50, 5, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(50), mail, new ThreadPoolExecutor.DiscardPolicy());
    }

}
