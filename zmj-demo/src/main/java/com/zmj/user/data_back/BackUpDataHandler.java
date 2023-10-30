package com.zmj.user.data_back;

/**
 * 数据归档接口
 *
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 22:59
 */
public interface BackUpDataHandler {
    /**
     * 获取场景
     * */
    BackUpDataSceneEnum getScene();


    /**
     * 数据归档
     * */
    void backUpData();



}
