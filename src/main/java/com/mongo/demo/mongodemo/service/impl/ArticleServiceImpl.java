package com.mongo.demo.mongodemo.service.impl;

import com.mongo.demo.mongodemo.core.PageInfo;
import com.mongo.demo.mongodemo.dao.ArticleDao;
import com.mongo.demo.mongodemo.entity.Article;
import com.mongo.demo.mongodemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章接口实现
 *
 * @author hejq
 * @date 2019/5/28 15:30
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 单个添加文章信息
     *
     * @param article 文章
     * @return 添加结果
     */
    @Override
    public Article save(Article article) {
        return articleDao.save(article);
    }

    /**
     * 批量插入文章数据
     *
     * @param articleList 文章数据
     * @return 操作结果
     */
    @Override
    public List<Article> insert(List<Article> articleList) {
        return articleDao.insert(articleList);
    }

    /**
     * 通过标题精确查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    @Override
    public Article findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    /**
     * 通过标题模糊查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    @Override
    public List<Article> findByTitleLike(String title) {
        return articleDao.findByTitleLike(title);
    }

    /**
     * 分页查询文章信息
     *
     * @param page 分页信息
     * @return 精确查询结果
     */
    @Override
    public Page<Article> findAll(PageInfo page) {
        Article article = new Article();
        article.setTitle(page.getKeyword());
        ExampleMatcher matcher = ExampleMatcher.matching()
                //改变默认字符串匹配方式：模糊查询
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                //改变默认大小写忽略方式：忽略大小写
                .withIgnoreCase(true)
                //采用“包含匹配”的方式查询
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                //忽略属性，不参与查询;
                .withIgnorePaths("page", "size", "date");
        Example<Article> example = Example.of(article, matcher);
        return articleDao.findAll(example, page);
    }
}
