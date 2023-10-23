package com.zmj.test.demo;

import com.zmj.user.UserApplication;
import com.zmj.user.entity.SysUser;
import com.zmj.user.service.SysUserService;

import com.zmj.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/18 21:45
 */
@SpringBootTest(classes = UserApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserService userService;

    @Test
    public void testQuery(){

    }

    @Test
    public void testAopUtils(){
        Class<?> targetClass = AopUtils.getTargetClass(sysUserService);
        System.out.println(targetClass);
    }
}
