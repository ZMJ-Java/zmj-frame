package com.zmj.user.designPattern.filterPattern.entity;

import lombok.Data;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 18:55
 */
@Data
public class Article {

    private Long id;

    private Long wordCount;

    private String author;

    private ArticleContext articleContext;



}
