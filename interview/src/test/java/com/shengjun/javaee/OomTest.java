package com.shengjun.javaee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/8/1 10:03
 */
public class OomTest {
    static List<String> list = new ArrayList<>();

    /**
     * 测试由于静态集合的生命周期和jvm的生命周期一致，
     * 存储了大量的数据，得不到释放导致的oom现象。
     */
    @Test
    public void testStaticListOom(){
        int i = 0;
        while (true) {
            System.out.println(i++);
            list.add("你好");
        }
    }
}
