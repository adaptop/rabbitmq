package com.shengjun.javaee;

import org.junit.Test;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/7/31 10:30
 */
public class BitOperation {

    /**
     * 测试位运算
     */
    @Test
    public void test(){
        // 用最有效率的方法计算2乘以8？
        System.out.println(2 << 3); //数字的二进制左移三位相当于乘以2的三次方
        System.out.println(8 >> 1);
        System.out.println(3 << 4);
    }
}
