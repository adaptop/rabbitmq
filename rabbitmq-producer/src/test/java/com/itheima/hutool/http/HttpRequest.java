package com.itheima.hutool.http;

import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/7/29 10:17
 */
public class HttpRequest {

    @Test
    public void httpRequestGet(){
        String url = "https://eolink.o.apispace.com/456456/weather/v001/now";
        Map<String,Object> map = new HashMap<>();
      /*  map.put("X-APISpace-Token","vsk7ffdv79z99knjldglc9zqfv4qrtkd");
        map.put("Authorization-Type","apikey");*/
        map.put("areacode","101010100");
        String result = cn.hutool.http.HttpRequest.get(url).header("X-APISpace-Token", "vsk7ffdv79z99knjldglc9zqfv4qrtkd").header("Authorization-Type", "apikey").form(map).timeout(1000).execute().body();
        System.out.println(result);

        char a = '1';
        int b = a;
        short c = 1;
        long d = 1;

    }
}
