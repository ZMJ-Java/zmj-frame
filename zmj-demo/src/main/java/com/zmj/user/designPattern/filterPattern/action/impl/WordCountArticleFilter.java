package com.zmj.user.designPattern.filterPattern.action.impl;

import com.zmj.user.designPattern.filterPattern.action.BaseArticleFilter;
import com.zmj.user.designPattern.filterPattern.entity.Article;
import com.zmj.user.designPattern.filterPattern.entity.ArticleContext;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 19:02
 */
public class WordCountArticleFilter extends BaseArticleFilter {
    @Override
    public boolean doFilter(ArticleContext articleContext) {
        Article article = articleContext.getArticle();

        //执行当前的字数过滤逻辑，来判断是否留下这篇文章
        //如果过滤了，可以走抽像类的公共方法
        Long wordCount = article.getWordCount();
        if (wordCount > 10) {
            return true;
        }

        return false;


    }
}
