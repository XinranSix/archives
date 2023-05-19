package com.yupi.usercenter;

import com.yupi.usercenter.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class UserCenterApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void testDigest() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest("abcd".getBytes(StandardCharsets.UTF_8));
        String result = new String(bytes);
        System.out.println(result);
    }
}
