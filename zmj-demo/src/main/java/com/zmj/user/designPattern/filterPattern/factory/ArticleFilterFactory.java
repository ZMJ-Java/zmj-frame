package com.zmj.user.designPattern.filterPattern.factory;

import com.zmj.user.designPattern.filterPattern.action.IArticleFilter;
import com.zmj.user.designPattern.filterPattern.action.impl.WordCountArticleFilter;
import com.zmj.user.designPattern.filterPattern.entity.ArticleFilterEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 19:08
 */
public class ArticleFilterFactory {


    private ArticleFilterFactory() {
    }

    public static List<IArticleFilter> createArticleFilter(List<ArticleFilterEnum> articleFilterEnumList) {

        List<IArticleFilter> articleFilterList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(articleFilterEnumList)) {

            articleFilterEnumList.stream().map(x ->
                    ArticleFilterFactory.createFilter(x)
            ).collect(Collectors.toList());
        }
        return articleFilterList;
    }


    private static Object createFilter(ArticleFilterEnum articleFilterEnum) {
        IArticleFilter iArticleFilter = null;

        switch (articleFilterEnum) {
            case WORD_COUNT:
                iArticleFilter = new WordCountArticleFilter();
                break;
            default:
                break;
        }
        return iArticleFilter;
    }
}
