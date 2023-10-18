package com.zmj.user.designPattern.templatePattern.prod;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.prod
 * @describe api行为定义
 * @date 2023/10/17 14:59
 */
public interface Action {

    /**
     * 参数校验，可以自定义异常输出
     */
    void validate();

    /**
     * 方法执行
     */
    void execute();

    /**
     * 后续
     */
    void after();
}
