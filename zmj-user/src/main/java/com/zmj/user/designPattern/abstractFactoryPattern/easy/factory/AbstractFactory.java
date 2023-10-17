package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Color;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory
 * @date 2023/10/17 15:46
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
