package com.itheima.producer;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/6/27 19:00
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitmq中的工作模式
 */
public class Producer_WorkQueues {
    public static void main(String[] args) throws Exception{
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.200.129");
        factory.setPort(5672);
        factory.setVirtualHost("/lsj");
        factory.setUsername("lsj");
        factory.setPassword("lsj");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 创建队列
        channel.queueDeclare("work_queues",true,false,false,null);
        for (int i = 0; i < 100000; i++) {
            String body = "work_queues message" +"  序号："+ i + ((i%2 == 0) ? "偶数" : "单数");
            // 发布消息
            channel.basicPublish("","work_queues",null,body.getBytes());
        }

    }
}
