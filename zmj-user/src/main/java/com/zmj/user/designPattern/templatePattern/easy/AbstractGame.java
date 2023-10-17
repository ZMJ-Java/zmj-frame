package com.zmj.user.designPattern.templatePattern.easy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.easy
 * @date 2023/10/17 14:49
 */
public abstract class AbstractGame {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();


    //模板
    public final void play(){
        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }


}
