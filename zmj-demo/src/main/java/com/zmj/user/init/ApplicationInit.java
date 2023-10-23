package com.zmj.user.init;

import com.alibaba.fastjson.JSON;
import com.zmj.user.designPattern.buildPattern.SkuDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ZMJ
 * @Package com.zmj.user.init
 * @date 2023/10/22 16:03
 */
@Component
@Slf4j
public class ApplicationInit implements ApplicationListener<ApplicationReadyEvent> {

    private Map<String, InitFunction> initFunctionMap = new HashMap<>();

    {
        initFunctionMap.put("预热fastJson", this::initFastJson);

    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initFunctionMap.forEach((desc, function) -> {
            try {
                long startTime = System.currentTimeMillis();
                function.invoke();
                log.info("ApplicationInit{}.costTime:{}", desc, System.currentTimeMillis() - startTime);
            } catch (Exception e) {
                log.error("ApplicationInit{} ERROR", desc, e);
            }
        });


    }


    private void initFastJson() {
        SkuDo skuDo = new SkuDo();
        skuDo.setSkuId(1L);
        skuDo.setSkuName("Apple");

        String str = JSON.toJSONString(skuDo);
        System.out.println(str);

        JSON.parseObject(str, SkuDo.class);

    }


    interface InitFunction {
        void invoke();
    }
}
