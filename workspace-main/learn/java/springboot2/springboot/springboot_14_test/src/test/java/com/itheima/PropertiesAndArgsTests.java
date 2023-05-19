package com.itheima;

import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = {"--test.prop=testValue2"})
public class PropertiesAndArgsTests {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties() {
        System.out.println(msg);
        System.out.println(bookCase);
    }

}
