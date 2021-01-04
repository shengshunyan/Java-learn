package com.guoshi.test;

import com.guoshi.config.RabbitMQClient;
import com.rabbitmq.client.Connection;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Demo1 {
    @Test
    public void getConnection() throws IOException, TimeoutException {
        Connection connection = RabbitMQClient.getConnection();

        connection.close();
    }
}
