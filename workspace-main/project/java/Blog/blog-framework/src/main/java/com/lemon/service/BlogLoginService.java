package com.lemon.service;

import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
