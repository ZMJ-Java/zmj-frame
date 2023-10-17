package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Blue;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Green;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Red;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Color;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory
 * @date 2023/10/17 15:47
 */
public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
