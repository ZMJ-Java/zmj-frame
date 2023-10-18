package com.zmj.user.designPattern.abstractFactoryPattern.demo.handler;

import com.zmj.user.designPattern.abstractFactoryPattern.demo.PayChannelEnum;
import com.zmj.user.designPattern.abstractFactoryPattern.demo.PayHandler;
import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo.handler
 * @date 2023/10/17 19:15
 */
@Component
public class WeChatPayHandler implements PayHandler {
    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.WeChatPay;
    }

    @Override
    public void dealPay() {
        System.out.println("微信支付，具体逻辑省略。。。");
    }
}
