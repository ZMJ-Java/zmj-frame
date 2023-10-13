package com.zmj.user.controller;

import com.zmj.bean.Result;
import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.req.UserListReq;
import com.zmj.user.entity.req.UserReq;
import com.zmj.user.service.UserService;
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
        /* int i = 1 / 0;*/
        return Result.ok(userService.addUser(userDto));

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Integer id) {
        return Result.ok(userService.deleteUserById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserPage")
    public Result getPage(@RequestBody UserListReq userListReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userListReq, userDto);
        return Result.ok(userService.getUserPage(userDto));
    }


}
