package com.zmj.user.designPattern.templatePattern.prod;

import com.zmj.bean.Result;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.prod
 * @date 2023/10/17 15:01
 */
public class ApiTemplateDemo {
    public static void main(String[] args) {
        ApiTemplate apiTemplate = new ApiTemplate();

        Result result = Result.ok();

        apiTemplate.execute(result, new Action() {
            @Override
            public void validate() {
                System.out.println("开始校验参数");
            }

            @Override
            public void execute() {
                System.out.println("开始执行");
            }

            @Override
            public void after() {
                System.out.println("后续执行");
            }
        });

        System.out.println(result);
    }
}
