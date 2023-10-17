package com.zmj.user.designPattern.templatePattern.easy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.easy
 * @date 2023/10/17 14:54
 */
public class Cricket extends AbstractGame{
    @Override
    void initialize() {
        System.out.println("板球游戏初始化");
    }

    @Override
    void startPlay() {
        System.out.println("板球游戏开始了");
    }

    @Override
    void endPlay() {
        System.out.println("板球游戏结束了");
    }
}
