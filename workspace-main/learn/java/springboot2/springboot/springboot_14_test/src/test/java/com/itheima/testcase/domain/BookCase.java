package com.itheima.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {

    private Integer id;
    private Integer id2;
    private String name;
    private String uuid;
    private long publishTime;
}
