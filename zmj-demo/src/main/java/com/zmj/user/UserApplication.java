package com.zmj.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ZMJ
 * @Package com.zmj.user
 * @date 2023/10/11 9:54
 */

@SpringBootApplication
@MapperScan(value = {"com.zmj.*.dao"})
@ComponentScan(value = "com.zmj")
public class UserApplication {
    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class);
    }
}
