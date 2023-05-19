package com.lemon.wje.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemon.wje.unils.JWTUtils;
import com.lemon.wje.unils.R;
import com.lemon.wje.entity.User;
import com.lemon.wje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public R login(@RequestBody User user) {
        System.out.println(user);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername());

        User user1 = userService.getOne(wrapper);

        R r = new R();

        if (null == user1) {
            r.setFlag(false);
            r.setMessage("用户不存在");
            return r;
        }
        wrapper.eq(User::getPassword, user.getPassword());
        user1 = userService.getOne(wrapper);
        if (null == user1) {
            r.setFlag(false);
            r.setMessage("密码错误");
            return r;
        }
        String token = JWTUtils.getToken(user1);
        r.setFlag(true);
        r.setMessage("登陆成功");
        r.setData(user1);
        r.setToken(token);
        return r;
    }

}
