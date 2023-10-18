package com.zmj.user.designPattern.filterPattern;

import com.zmj.user.designPattern.filterPattern.action.IArticleFilter;
import com.zmj.user.designPattern.filterPattern.entity.Article;
import com.zmj.user.designPattern.filterPattern.entity.ArticleContext;
import com.zmj.user.designPattern.filterPattern.entity.ArticleFilterEnum;
import com.zmj.user.designPattern.filterPattern.factory.ArticleFilterFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 20:32
 */
public class ArticleFilterDemo {

    private List<ArticleFilterEnum> articleFilterEnumList;

    private List<IArticleFilter> iArticleFilterList;

    private void init() {
        this.iArticleFilterList = ArticleFilterFactory.createArticleFilter(articleFilterEnumList);
    }

    public void doFilter(List<Article> articleList) {
        articleList.stream().filter(article -> {
            ArticleContext articleContext = new ArticleContext();
            articleContext.setArticle(article);
            return doFilter(articleContext);
        }).collect(Collectors.toList());
    }


    private boolean doFilter(ArticleContext articleContext) {
        for (IArticleFilter iArticleFilter : iArticleFilterList) {
            if (iArticleFilter.doFilter(articleContext)) {
                return false;
            }
        }
        return true;
    }
}
