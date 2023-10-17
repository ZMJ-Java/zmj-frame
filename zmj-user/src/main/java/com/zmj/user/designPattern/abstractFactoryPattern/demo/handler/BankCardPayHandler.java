package com.zmj.user.designPattern.abstractFactoryPattern.demo.handler;

import com.zmj.user.designPattern.abstractFactoryPattern.demo.PayChannelEnum;
import com.zmj.user.designPattern.abstractFactoryPattern.demo.PayHandler;
import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo.handler
 * @date 2023/10/17 19:15
 */

public class BankCardPayHandler implements PayHandler {
    @Override
    public PayChannelEnum getChannel() {
        return null;
    }

    @Override
    public void dealPay() {

    }
}
