package com.mongo.demo.mongodemo.controller;

import com.mongo.demo.mongodemo.core.PageInfo;
import com.mongo.demo.mongodemo.core.ResultMap;
import com.mongo.demo.mongodemo.entity.Article;
import com.mongo.demo.mongodemo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章接口
 *
 * @author hejq
 * @date 2019/5/28 14:56
 */
@RestController
@RequestMapping("/mg/article")
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 单个添加文章信息
     *
     * @param article 文章
     * @return 添加结果
     */
    @PostMapping("/add")
    public ResultMap add(@RequestBody Article article) {
        log.debug("单个添加文章信息 {}", article);
        article = articleService.save(article);
        return ResultMap.success(article);
    }

    /**
     * 批量插入文章数据
     *
     * @param articleList 文章数据
     * @return 操作结果
     */
    @PostMapping("/batchInsert")
    public ResultMap batchInsert(@RequestBody List<Article> articleList) {
        log.debug("批量插入文章数据 {}", articleList);
        articleList = articleService.insert(articleList);
        return ResultMap.success(articleList);
    }

    /**
     * 通过标题精确查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    @GetMapping("/findByTitle")
    public ResultMap findByTitle(String title) {
        log.debug("通过标题精确查询文章信息 title->{}", title);
        Article article = articleService.findByTitle(title);
        return ResultMap.success(article);
    }

    /**
     * 通过标题模糊查询文章信息
     *
     * @param title 标题
     * @return 精确查询结果
     */
    @GetMapping("/findByTitleLike")
    public ResultMap findByTitleLike(String title) {
        log.debug("通过标题模糊查询文章信息 title->{}", title);
        List<Article> articleList = articleService.findByTitleLike(title);
        return ResultMap.success(articleList);
    }

    /**
     * 分页查询文章信息
     *
     * @param page 分页信息
     * @return 精确查询结果
     */
    @GetMapping("/page")
    public ResultMap findByPageInfo(@PageableDefault PageInfo page) {
        log.debug("分页查询文章信息 {}", page);
        Page<Article> articlePageInfo = articleService.findAll(page);
        return ResultMap.success(articlePageInfo);
    }
}
