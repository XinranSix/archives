package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Book {
    private Integer Id;
    private String type;
    private String name;
    private String description;
}
