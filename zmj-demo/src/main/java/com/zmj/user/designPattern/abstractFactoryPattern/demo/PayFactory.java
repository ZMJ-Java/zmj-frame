package com.zmj.user.designPattern.abstractFactoryPattern.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo
 * @date 2023/10/17 19:17
 */

@Component
public class PayFactory implements InitializingBean{


    @Resource
    private List<PayHandler> payHandlerList;

    private Map<PayChannelEnum, PayHandler> handlerMap = new HashMap<>();


    public PayHandler getHandlerByCode(int code) {
        PayChannelEnum payChannelEnum = PayChannelEnum.getPayChannelByCode(code);
        return handlerMap.get(payChannelEnum);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (PayHandler payHandler : payHandlerList) {
            handlerMap.put(payHandler.getChannel(), payHandler);
            System.out.println("支付渠道：" + payHandler.getChannel().toString() + "加入容器");
        }
    }
}
