package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Blue;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Green;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.color.Red;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.shape.Circle;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.shape.Rectangle;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entity.shape.Square;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Color;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory
 * @date 2023/10/17 15:47
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("Square")) {
            return new Square();
        } else if (shape.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }


}
