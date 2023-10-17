package com.zmj.user.designPattern.templatePattern.easy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.easy
 * @date 2023/10/17 14:52
 */
public class Football extends AbstractGame{
    @Override
    void initialize() {
        System.out.println("初始化足球游戏");
    }

    @Override
    void startPlay() {
        System.out.println("开始足球游戏");
    }

    @Override
    void endPlay() {
        System.out.println("结束足球游戏");
    }
}
