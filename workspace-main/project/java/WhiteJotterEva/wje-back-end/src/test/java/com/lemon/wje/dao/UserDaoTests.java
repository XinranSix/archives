package com.lemon.wje.dao;

import com.lemon.wje.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTests {

    @Autowired
    UserDao userDao;

    @Test
    void testSelectList() {
        userDao.selectList(null).forEach(System.out::println);
    }

    @Test
    void testSelectById() {
        System.out.println(userDao.selectById(1));
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("hyt");
        user.setPassword("hyt");
        userDao.insert(user);
    }

    @Test
    void testDeleteById() {
        userDao.deleteById(5);
    }
}
