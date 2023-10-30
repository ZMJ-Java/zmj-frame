package com.zmj.user.data_back;

/**
 * 数据归档service
 *
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:37
 */
public interface BackUpService {

    /**
     * 数据归档
     */
    void backUp(BackUpDataSceneEnum sceneEnum);

}
