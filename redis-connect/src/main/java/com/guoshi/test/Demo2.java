package com.guoshi.test;

import com.guoshi.entity.User;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;

public class Demo2 {
    // 存储对象 - 以byte[]形式存储在Redis中
    @Test
    public void setByteArray() {
        // 1. 连接redis
        Jedis jedis = new Jedis("129.204.110.90", 6379);

        // 2.1 准备key(String)-value(User)
        String key = "user";
        User value = new User(1, "张三", new Date());
        // 2.2 准备key和value转换为byte[]
        byte[] byteKey = SerializationUtils.serialize(key);
        byte[] byteValue = SerializationUtils.serialize(value);
        // 2.3 将key和value存储到Redis
        jedis.set(byteKey, byteValue);

        // 3. 释放资源
        jedis.close();
    }

    @Test
    public void getByteArray() {
        // 1. 连接redis
        Jedis jedis = new Jedis("129.204.110.90", 6379);

        // 取出数据
        String key = "user";
        byte[] byteKey = SerializationUtils.serialize(key);
        byte[] byteValue = jedis.get(byteKey);
        User value = (User) SerializationUtils.deserialize(byteValue);

        System.out.println(value);

        // 3. 释放资源
        jedis.close();
    }

}
