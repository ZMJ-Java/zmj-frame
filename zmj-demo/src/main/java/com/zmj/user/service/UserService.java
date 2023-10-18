package com.zmj.user.service;

import com.zmj.entity.PageResult;
import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.po.UserPo;


/**
 * @author ZMJ
 * @Package com.zmj.user.service
 * @date 2023/10/11 20:45
 */
public interface UserService {

    int addUser(UserDto userDto);

    int deleteUserById(Integer id);

    PageResult<UserPo> getUserPage(UserDto userDto);

}
