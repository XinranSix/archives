package com.lemon.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.reggie.entity.Category;

public interface CategoryService extends IService<Category> {

    /**
     * 根据 id 删除分类，删除之前需要进行判断
     * @param id
     */
    void remove(Long id);
}
