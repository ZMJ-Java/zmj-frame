package com.zmj.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zmj.entity.PageResult;
import com.zmj.user.convert.UserPoConverter;
import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.po.UserPo;
import com.zmj.user.dao.UserMapper;
import com.zmj.user.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author ZMJ
 * @Package com.zmj.user.service.impl
 * @date 2023/10/11 20:48
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(UserDto userDto) {
        //mapstruct 实现拷贝属性
        UserPo userPo = UserPoConverter.USER_PO_CONVERTER.converterToUserPo(userDto);

        Integer count =Integer.valueOf(userMapper.insert(userPo)) ;
        System.out.println("com.zmj.user.service.impl.UserServiceImpl.addUser count="+ count);
        return count;
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return Integer.valueOf(userMapper.deleteById(id)) ;
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
