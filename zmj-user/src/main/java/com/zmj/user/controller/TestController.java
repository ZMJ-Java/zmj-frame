package com.zmj.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZMJ
 * @Package com.zmj.user.controller
 * @date 2023/10/11 10:07
 */
@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "hello world";
    }

}
