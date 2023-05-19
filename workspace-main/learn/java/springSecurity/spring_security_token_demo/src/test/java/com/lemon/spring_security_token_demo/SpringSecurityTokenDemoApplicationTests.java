package com.lemon.spring_security_token_demo;

import com.lemon.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityTokenDemoApplicationTests {

    @Test
    void contextLoads(@Autowired UserMapper userMapper) {
        userMapper.selectList(null).forEach(System.out::println);
    }

}
