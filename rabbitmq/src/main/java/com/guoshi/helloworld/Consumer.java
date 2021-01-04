package com.guoshi.helloworld;

import com.guoshi.config.RabbitMQClient;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;

public class Consumer {
    @Test
    public void consumer() throws Exception {
        Connection connection = RabbitMQClient.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("HelloWorld", true, false, false, null);

        DefaultConsumer consume = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到消息：" + new String(body, "UTF-8"));
            }
        };
        channel.basicConsume("HelloWorld", true, consume);

        System.out.println("消费者开始监听队列");
        System.in.read();

        channel.close();
        connection.close();
    }
}
