package com.mongo.demo.mongodemo.dao;

import com.mongo.demo.mongodemo.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章数据库接口
 *
 * @author hejq
 * @date 2019/5/28 14:57
 */
@Repository
public interface ArticleDao extends MongoRepository<Article, Integer> {

    /**
     * 通过标题查询文章信息
     *
     * @param title 标题
     * @return 文章
     */
    Article findByTitle(String title);

    /**
     * 通过标题模糊查询文章信息
     *
     * @param title 标题
     * @return 文章
     */
    List<Article> findByTitleLike(String title);

}
