package com.zmj.user.designPattern.templatePattern.easy;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.easy
 * @date 2023/10/17 14:56
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        AbstractGame game = new Football();

        game.play();

        game = new Cricket();

        game.play();




    }
}
