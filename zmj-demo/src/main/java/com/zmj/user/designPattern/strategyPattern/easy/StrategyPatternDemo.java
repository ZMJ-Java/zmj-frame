package com.zmj.user.designPattern.strategyPattern.easy;

import com.zmj.user.designPattern.strategyPattern.easy.operation.OperationAdd;
import com.zmj.user.designPattern.strategyPattern.easy.operation.OperationMultiply;
import com.zmj.user.designPattern.strategyPattern.easy.operation.OperationSubtract;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.strategyPattern.easy
 * @date 2023/10/17 16:25
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.excuteOperation(1, 2));

        context = new Context(new OperationMultiply());
        System.out.println(context.excuteOperation(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println(context.excuteOperation(100, 29));
    }
}
