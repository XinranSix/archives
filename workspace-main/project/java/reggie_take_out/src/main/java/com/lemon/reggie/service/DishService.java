package com.lemon.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.reggie.dto.DishDto;
import com.lemon.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    /**
     * 新增菜品，同时插入对应的口味数据
     *
     * @param dishDto
     */
    void saveWithFlavor(DishDto dishDto);

    /**
     * 根据 id 来查询对应的菜品信息和口味信息
     *
     * @param id
     * @return
     */
    DishDto getByIdWithFlavor(Long id);

    /**
     * 更新菜品信息，同时更新口味信息
     *
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);
}
