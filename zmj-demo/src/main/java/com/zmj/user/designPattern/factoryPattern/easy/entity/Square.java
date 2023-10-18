package com.zmj.user.designPattern.factoryPattern.easy.entity;

import com.zmj.user.designPattern.factoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.factoryPattern.easy
 * @date 2023/10/17 15:26
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
