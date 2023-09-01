package com.itheima.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.entity.User;
import com.rabbitmq.client.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/6/27 11:42
 */
public class Consumer_HelloWorld {
    public static void main(String[] args) throws Exception{
        // 1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2、设置参数
        factory.setHost("192.168.200.129"); // ip 默认值localhost
        factory.setPort(5672); // 端口 默认值5672
        factory.setVirtualHost("/lsj"); // 虚拟机 默认值 /
        factory.setUsername("lsj"); // 用户名 默认值 guest
        factory.setPassword("lsj"); // 密码 默认值guest
        // 3、创建连接
        Connection connection = factory.newConnection();
        //4、创建channel
        Channel channel = connection.createChannel();
        //5. 创建队列Queue
        /*
        queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        参数：
            1. queue：队列名称
            2. durable:是否持久化，当mq重启之后，还在
            3. exclusive：
                * 是否独占。只能有一个消费者监听这队列
                * 当Connection关闭时，是否删除队列
                *
            4. autoDelete:是否自动删除。当没有Consumer时，自动删除掉
            5. arguments：参数。

         */
        //如果没有一个名字叫hello_world的队列，则会创建该队列，如果有则不会创建
        //channel.queueDeclare("hello_world",true,false,false,null);

        /*
        basicConsume(String queue, boolean autoAck, Consumer callback)
        参数：
            1. queue：队列名称
            2. autoAck：是否自动确认
            3. callback：回调对象

         */
        // 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            int i = 0;
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag："+consumerTag);
                System.out.println("Exchange："+envelope.getExchange());
                System.out.println("RoutingKey："+envelope.getRoutingKey());
                System.out.println("properties："+properties);
                //System.out.println("body："+new String(body));
               /* ObjectMapper mapper = new ObjectMapper();
                User user = mapper.readValue(body, User.class);
                System.out.println(user.getName());*/
                File file = new File("C:\\Users\\WN\\Desktop\\人体艺术\\魅惑系列"+ ++i + ".jpg");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(body);
            }
        };
        channel.basicConsume("hello_world",true,consumer);
        //关闭资源？不要
    }

}
