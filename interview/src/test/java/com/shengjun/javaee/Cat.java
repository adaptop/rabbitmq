package com.shengjun.javaee;

import java.io.Serializable;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/8/12 10:07
 */
public class Cat implements Serializable {

    private String name;

    private int age;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void say(){
        System.out.println("hello，我是一只猫");
    }

    public void run(){
        System.out.println("大家快来看小猫跑步啊");
    }
}
