package com.zmj.user.designPattern.strategyPattern.easy.operation;

import com.zmj.user.designPattern.strategyPattern.easy.Strategy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.strategyPattern.easy.operation
 * @date 2023/10/17 16:22
 */
public class OperationSubtract implements Strategy {
    @Override
    public long doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
