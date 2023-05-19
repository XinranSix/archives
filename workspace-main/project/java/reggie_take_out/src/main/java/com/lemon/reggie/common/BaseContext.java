package com.lemon.reggie.common;

/**
 * 基于 ThreadLocal 封装的工具类，用户保存和获取当前登录用户 id
 */
public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
