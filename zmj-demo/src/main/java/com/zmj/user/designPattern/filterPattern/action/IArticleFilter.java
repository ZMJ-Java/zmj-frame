package com.zmj.user.designPattern.filterPattern.action;

import com.zmj.user.designPattern.filterPattern.entity.ArticleContext;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 18:57
 */
public interface IArticleFilter {

    boolean doFilter(ArticleContext articleContext);


}
