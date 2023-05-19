package com.lemon.reggie.service;

import com.lemon.reggie.entity.Orders;

public interface OrdersService {

    /**
     * 用户下单
     *
     * @param orders
     */
    void submit(Orders orders);
}
