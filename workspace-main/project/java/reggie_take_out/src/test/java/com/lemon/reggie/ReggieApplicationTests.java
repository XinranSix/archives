package com.lemon.reggie;

import com.lemon.reggie.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class ReggieApplicationTests {

    @Test
    void test1() {
        System.out.println(String.format("test %s 12", "已经"));
    }
}
