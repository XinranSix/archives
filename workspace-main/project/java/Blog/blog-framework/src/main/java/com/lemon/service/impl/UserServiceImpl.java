package com.lemon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.domain.entity.User;
import com.lemon.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.lemon.service.UserService;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-02-23 19:17:01
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

