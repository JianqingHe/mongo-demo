package com.mongo.demo.mongodemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * 文章
 *
 * @author hejq
 * @date 2019/5/28 14:55
 */
@Data
public class Article {

    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title = "";

    /**
     * 内容
     */
    private String content = "";

    /**
     * 创建时间
     */
    private Date date = new Date(System.currentTimeMillis());
}
