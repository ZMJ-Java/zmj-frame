package com.zmj.user.designPattern.abstractFactoryPattern.easy;

import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Color;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.entityInterface.Shape;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.factory.AbstractFactory;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.factory.ColorFactory;
import com.zmj.user.designPattern.abstractFactoryPattern.easy.factory.FactoryProducer;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy
 * @date 2023/10/17 15:58
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");

        //生产红色
        Color red = colorFactory.getColor("Red");
        red.fill();

        //生产绿色
        Color green = colorFactory.getColor("Green");
        green.fill();

        //生产蓝色
        Color blue = colorFactory.getColor("Blue");
        blue.fill();

        //生产三角形
        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();

        //生产正方形
        Shape square = shapeFactory.getShape("Square");
        square.draw();

        //生产圆形
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();



    }
}
