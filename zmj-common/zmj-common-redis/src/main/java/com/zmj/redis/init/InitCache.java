package com.zmj.redis.init;

import com.zmj.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Map;

/**
 * @author ZMJ
 * @Package com.zmj.redis.init
 * @date 2023/10/16 8:25
 */
@Component
public class InitCache implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //那些缓存需要预热
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        //调用init()方法
        if (beanMap.isEmpty()) {
            return;

        }
        for (Map.Entry<String, AbstractCache> entry : beanMap.entrySet()) {
            AbstractCache abstractCache =(AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());

            abstractCache.initCache();
        }

    }
}
