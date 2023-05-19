package com.lemon.wje.service;

import com.lemon.wje.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    void testGetById() {
        System.out.println(userService.getById(1));
    }

    @Test
    void testList() {
        userService.list().forEach(System.out::println);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("yj");
        user.setPassword("yj");
        userService.save(user);
    }
}
