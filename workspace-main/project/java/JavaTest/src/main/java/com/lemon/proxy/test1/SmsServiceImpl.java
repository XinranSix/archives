package com.lemon.proxy.test1;

public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
