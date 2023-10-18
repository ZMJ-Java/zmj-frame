package com.zmj.user.designPattern.buildPattern;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.buildPattern
 * @date 2023/10/18 15:56
 */
public interface SkuVoFunction<T extends SkuVo> {

    T newInstance();
}
