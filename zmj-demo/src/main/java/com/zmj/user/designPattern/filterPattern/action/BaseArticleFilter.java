package com.zmj.user.designPattern.filterPattern.action;

import com.zmj.user.designPattern.filterPattern.entity.ArticleContext;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 18:58
 */
public abstract class BaseArticleFilter implements IArticleFilter {

   public abstract boolean doFilter(ArticleContext articleContext);

    void filter(ArticleContext articleContext) {
        //过滤
        doFilter(articleContext);
        //各种操作
        //发送通知
        sendMsg();
    }


     void sendMsg() {
        //发送通知
    }
}
