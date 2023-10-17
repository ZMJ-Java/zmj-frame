package com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.shape;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.shape
 * @date 2023/10/17 15:45
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw");
    }
}
