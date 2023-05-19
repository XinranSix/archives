package com.itheima.service.impl;

import com.itheima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

// @Service
public class MessageServiceImpl implements MessageService {

    // @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列，id：" + id);
        // jmsMessagingTemplate.convertAndSend(id);
        jmsMessagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String doMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("已完成短信发送业务，id：" + id);
        return id;
    }
}
