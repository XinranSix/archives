package com.lemon.controller;

import com.lemon.domain.ResponseResult;
import com.lemon.service.ArticleService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

/**
 * 文章相关接口
 *
 * @author yaojie
 */
@RestController
@RequestMapping("/article")
@MapperScan("com.lemon.mapper")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 热门文章列表
     *
     * @return
     */
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }
}
