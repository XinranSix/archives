package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-02-21 18:44:32
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

