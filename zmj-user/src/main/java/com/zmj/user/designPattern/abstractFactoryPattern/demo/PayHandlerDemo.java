package com.zmj.user.designPattern.abstractFactoryPattern.demo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo
 * @date 2023/10/17 19:23
 */

@Component
public class PayHandlerDemo {

    @Resource
    private PayFactory payFactory;

    public void dealPay(int code) {
        PayHandler payHandler = payFactory.getHandlerByCode(code);

        payHandler.dealPay();
    }

}
