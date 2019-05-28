package com.mongo.demo.mongodemo.service;

import com.mongo.demo.mongodemo.core.PageInfo;
import com.mongo.demo.mongodemo.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 文章接口
 *
 * @author hejq
 * @date 2019/5/28 15:30
 */
public interface ArticleService {

    /**
     * 单个添加文章信息
     *
     * @param article 文章
     * @return 添加结果
     */
    Article save(Article article);

    /**
     * 批量插入文章数据
     *
     * @param articleList 文章数据
     * @return 操作结果
     */
    List<Article> insert(List<Article> articleList);

    /**
     * 通过标题精确查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    Article findByTitle(String title);

    /**
     * 通过标题模糊查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    List<Article> findByTitleLike(String title);

    /**
     * 分页查询文章信息
     *
     * @param page 分页信息
     * @return 精确查询结果
     */
    Page<Article> findAll(PageInfo page);
}
