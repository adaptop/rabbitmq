package com.itheima.producer;

/**
 * @author: 梁胜君
 * @eamil: 132664666@qq.com
 * @date:2023/6/27 11:22
 */
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * 发送消息
 */
public class Producer_HelloWorld {
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
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
        //5、创建队列
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
        channel.queueDeclare("hello_world",true,false,false,null);
         /*
        basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
        参数：
            1. exchange：交换机名称。简单模式下交换机会使用默认的 ""
            2. routingKey：路由名称
            3. props：配置信息
            4. body：发送消息数据
         */
        /*for (int i = 0; i < 100000; i++) {
            String body = "hello, rabbitmq---"+i;
            // 发送消息
            channel.basicPublish("", "hello_world", null, body.getBytes());
        }*/
        /*for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setId(1+i);
            user.setAge(18+i);
            user.setMoney(new BigDecimal(1000));
            user.setName("梁胜君"+i);
            ObjectMapper mapper = new ObjectMapper();
            String jsonstr = mapper.writeValueAsString(user);
            channel.basicPublish("","hello_world",null,jsonstr.getBytes());
        }*/

        File file = new File("C:\\Users\\WN\\Desktop\\人体艺术\\张筱雨的魅惑系列");
        File[] files = file.listFiles();
        System.out.println(files.length);
        for (int i = 0; i < files.length; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            System.out.println(files[i]);
            byte[] bytes = new byte[(int) files[i].length()];
            fis.read(bytes);
            fis.close();
            channel.basicPublish("","hello_world",null,bytes);
        }


        //7、释放资源
        channel.close();
        connection.close();
        System.out.println((System.currentTimeMillis()-startTime)/1000);
    }
}
