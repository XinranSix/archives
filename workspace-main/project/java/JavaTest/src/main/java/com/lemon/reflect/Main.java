package com.lemon.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> targetClass = Class.forName("com.lemon.reflect.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);

        publicMethod.invoke(targetObject, "study");

        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "lxr");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
