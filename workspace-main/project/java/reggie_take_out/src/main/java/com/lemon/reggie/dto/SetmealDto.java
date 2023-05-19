package com.lemon.reggie.dto;

import com.lemon.reggie.entity.Setmeal;
import com.lemon.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
