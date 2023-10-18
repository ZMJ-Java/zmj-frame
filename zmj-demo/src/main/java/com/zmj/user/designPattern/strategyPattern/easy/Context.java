package com.zmj.user.designPattern.strategyPattern.easy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.strategyPattern.easy
 * @date 2023/10/17 16:23
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public long excuteOperation(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
