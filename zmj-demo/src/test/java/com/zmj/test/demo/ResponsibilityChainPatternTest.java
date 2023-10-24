package com.zmj.test.demo;

import com.alibaba.fastjson.JSON;
import com.zmj.user.UserApplication;
import com.zmj.user.designPattern.responsibilityChainPattern.ArticleInfo;
import com.zmj.user.designPattern.responsibilityChainPattern.RuleCheckComponent;
import com.zmj.user.designPattern.responsibilityChainPattern.RuleCheckResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZMJ
 * @Package com.zmj.test.demo
 * @date 2023/10/24 19:59
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ResponsibilityChainPatternTest {

    @Resource
    private RuleCheckComponent ruleCheckComponent;
    @Test
    public void test() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setTitle("zmj");
        articleInfo.setContent("zhanmaojun66666666666");
        RuleCheckResult ruleCheckResult = ruleCheckComponent.checkArticle(articleInfo);
        System.out.println(JSON.toJSONString(ruleCheckResult));
    }
}
