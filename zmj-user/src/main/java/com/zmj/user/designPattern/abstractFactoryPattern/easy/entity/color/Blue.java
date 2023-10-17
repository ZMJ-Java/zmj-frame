package com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Color;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color
 * @date 2023/10/17 15:45
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Blue::fill");
    }
}
