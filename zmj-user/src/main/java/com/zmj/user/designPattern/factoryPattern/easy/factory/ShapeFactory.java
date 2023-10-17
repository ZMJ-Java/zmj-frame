package com.zmj.user.designPattern.factoryPattern.easy.factory;

import com.zmj.user.designPattern.factoryPattern.easy.entity.Circle;
import com.zmj.user.designPattern.factoryPattern.easy.entity.Rectangle;
import com.zmj.user.designPattern.factoryPattern.easy.entity.Square;
import com.zmj.user.designPattern.factoryPattern.easy.entityInterface.Shape;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.factoryPattern.easy
 * @date 2023/10/17 15:27
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
