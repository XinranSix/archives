package com.itheima.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeUtils {

    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        String codeStr = String.valueOf(Math.abs((tele.hashCode() ^ 20236666 ^ System.currentTimeMillis() ^ new Random().nextLong()) % 1000000));
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }
}
