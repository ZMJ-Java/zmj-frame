package com.zmj.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zmj.entity.PageResult;
import com.zmj.user.convert.UserPoConverter;
import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.po.UserPo;
import com.zmj.user.mapper.UserMapper;
import com.zmj.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZMJ
 * @Package com.zmj.user.service.impl
 * @date 2023/10/11 20:48
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        /*
        BeanUtils拷贝属性
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        */

        //mapstruct 实现拷贝属性
        UserPo userPo = UserPoConverter.USER_PO_CONVERTER.converterToUserPo(userDto);

        int count = userMapper.insert(userPo);
        return count;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<UserPo> getUserPage(UserDto userDto) {
        IPage<UserPo> userPoIPage = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPoIPage);
        PageResult<UserPo> pageResult = new PageResult();
        pageResult.loadData(userPage);
        return pageResult;
    }
}
