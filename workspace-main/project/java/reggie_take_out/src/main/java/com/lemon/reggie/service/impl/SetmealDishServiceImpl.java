package com.lemon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.reggie.entity.SetmealDish;
import com.lemon.reggie.mapper.SetmealDishMapper;
import com.lemon.reggie.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SetmealDishServiceImpl
        extends ServiceImpl<SetmealDishMapper, SetmealDish>
        implements SetmealDishService {
}
