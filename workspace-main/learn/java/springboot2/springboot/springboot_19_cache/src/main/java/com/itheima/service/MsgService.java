package com.itheima.service;

public interface MsgService {

    String get(String tele);

    boolean check(String tele, String code);
}
