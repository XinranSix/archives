package com.itheima.service.impl;

import com.itheima.service.MessageService;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        System.out.println("订单处理开始");
        messageService.sendMessage(id);
        System.out.println("订单处理结束");
        System.out.println();
    }
}
