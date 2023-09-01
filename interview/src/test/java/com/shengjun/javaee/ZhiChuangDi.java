package com.shengjun.javaee;

import org.junit.Test;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/8/10 14:30
 */
public class ZhiChuangDi {

    @Test
    public void test1(){
        int a = 1;
        method1(1);
        System.out.println(a);

    }

    @Test
    public void test2(){
        String a = "hello";
        String b = "hello";
        System.out.println(a.intern() == b.intern());
        System.out.println(b.intern());
    }

    @Test
    public void test3(){
        try {
            int i = 10 / 0; // ctrl + atl + t
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void test(){
        System.out.println(method2());
    }

    public int method1(int a){
        return a + 1;
    }

    public static int method2(){
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println("3");
            //return 3;
        }
    }
}
