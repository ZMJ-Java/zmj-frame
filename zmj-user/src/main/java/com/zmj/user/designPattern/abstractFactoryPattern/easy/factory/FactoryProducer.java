package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.easy.factory
 * @date 2023/10/17 15:55
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }

}
