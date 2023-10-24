package com.zmj.user.controller;

import com.alibaba.fastjson.JSON;
import com.zmj.bean.Result;
import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.req.UserListReq;
import com.zmj.user.entity.req.UserReq;
import com.zmj.user.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZMJ
 * @Package com.zmj.user.controller
 * @date 2023/10/11 10:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public Result addUser(@RequestBody UserReq userReq) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        Integer i = userService.addUser(userDto);
        System.out.println("com.zmj.user.controller.UserController.addUser i="+i);
        i = 1;
        return Result.ok(i);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Integer id) {
        System.out.println("结果是： "+userService.deleteUserById(id));
        return Result.ok(userService.deleteUserById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getUserPage")
    public Result getPage(@RequestBody UserListReq userListReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userListReq, userDto);
        return Result.ok(userService.getUserPage(userDto));
    }


}
