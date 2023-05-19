package com.lemon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.reggie.entity.OrderDetail;
import com.lemon.reggie.entity.Orders;
import com.lemon.reggie.mapper.OrderDetailMapper;
import com.lemon.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
