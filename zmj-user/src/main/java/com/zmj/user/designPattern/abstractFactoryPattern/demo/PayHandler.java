package com.zmj.user.designPattern.abstractFactoryPattern.demo;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo
 * @date 2023/10/17 19:14
 */
public interface PayHandler {

    PayChannelEnum getChannel();

     void dealPay();
}
