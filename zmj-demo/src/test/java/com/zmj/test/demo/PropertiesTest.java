package com.zmj.test.demo;

import com.zmj.tool.PropertiesUtils;
import com.zmj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/24 15:19
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class PropertiesTest {

    @Test
    public void testProperties() throws Exception {
        String value = PropertiesUtils.getInstance().getPropertyValue("test","zmj.name");

        System.out.println(value);//zmj
    }


}
