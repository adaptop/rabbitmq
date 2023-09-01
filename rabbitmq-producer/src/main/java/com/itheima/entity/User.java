package com.itheima.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/6/27 18:48
 */
public class User implements Serializable {

    private Integer id;
    private String name;

    private int age;

    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
