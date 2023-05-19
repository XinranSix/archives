package com.lemon.controller;

import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.User;
import com.lemon.enums.AppHttpCodeEnum;
import com.lemon.exception.SystemException;
import com.lemon.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {

    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            // 提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.NEED_LOGIN);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout() {
        return blogLoginService.logout();
    }
}
