package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    /**
     * 获取热门文章列表
     *
     * @return
     */
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 获取文章详情
     *
     * @param id 文章 id
     * @return
     */
    ResponseResult getArticleDetail(Long id);
}
