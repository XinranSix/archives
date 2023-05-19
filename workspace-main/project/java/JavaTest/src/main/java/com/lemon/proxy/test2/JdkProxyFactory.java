package com.lemon.proxy.test2;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    public static <T> Object getProxy(Object target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
