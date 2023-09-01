package com.shengjun.javaee;

import java.util.Objects;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/8/1 14:18
 */
public class People {

    private String name;

    private int age;

    public People(){

    }
    public People(String name, int age) {
        this.name = name;
        this.age = age;
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

//   @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        People people = (People) o;
//        return age == people.age && Objects.equals(name, people.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    public static void main(String[] args) {
        People people1 = new People("梁胜君",18);
        People people2 = new People("梁胜君",18);
        System.out.println(people1.equals(people2));
    }
}
