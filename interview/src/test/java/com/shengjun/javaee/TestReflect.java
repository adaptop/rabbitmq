package com.shengjun.javaee;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/8/12 18:25
 */
import java.lang.reflect.Constructor;

/**
 * 反射类学习
 */
public class TestReflect {


    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.shengjun.javaee.Cat");
         Cat cat = (Cat) clazz.newInstance();
    }
}
