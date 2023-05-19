package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.constants.SystemConstants;
import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.Article;
import com.lemon.domain.entity.Category;
import com.lemon.domain.vo.CategoryVo;
import com.lemon.mapper.CategoryMapper;
import com.lemon.service.ArticleService;
import com.lemon.service.CategoryService;
import com.lemon.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-02-21 18:44:33
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final ArticleService articleService;

    public CategoryServiceImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseResult getCategoryList() {
        // 查询文章表 状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        // 获取文章的分类 id，去重
        Set<Long> categoryId = articleList.stream().
                map(Article::getCategoryId)
                .collect(Collectors.toSet());
        // 封装 vo
        List<Category> categories = listByIds(categoryId);
        categories = categories.stream().
                filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}

