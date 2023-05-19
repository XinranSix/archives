package com.lemon.reggie.controller;

import com.lemon.reggie.common.R;
import com.lemon.reggie.entity.Orders;
import com.lemon.reggie.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("orders = {}", orders);
        ordersService.submit(orders);
        return R.success("下单成功");
    }

//    Request URL: http://localhost:8080/order/userPage?page=1&pageSize=5
//    Request Method: GET
}
