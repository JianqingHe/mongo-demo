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

    private Integer id;

    private String title = "";

    private String content = "";

    private Date date = new Date(System.currentTimeMillis());
}
