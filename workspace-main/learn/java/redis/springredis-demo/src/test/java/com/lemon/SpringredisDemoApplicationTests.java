package com.lemon;

import com.lemon.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringredisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name", "富哥");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:100", new User("富哥", 21));
        User user = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println(user);
    }

}
