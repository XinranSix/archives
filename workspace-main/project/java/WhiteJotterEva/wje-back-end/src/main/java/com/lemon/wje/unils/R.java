package com.lemon.wje.unils;

import lombok.Data;

/**
 * 返回统一结果
 */

@Data
public class R {

    private Boolean flag;

    private Object data;

    private String message;

    private String token;
}
