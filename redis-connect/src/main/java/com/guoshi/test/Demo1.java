package com.guoshi.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Demo1 {
    @Test
    public void set() {
        // 1. 连接redis
        Jedis jedis = new Jedis("129.204.110.90", 6379);

        // 2. 操作redis
        jedis.set("name", "李四");

        // 3. 释放资源
        jedis.close();
    }

    @Test
    public void get() {
        // 1. 连接redis
        Jedis jedis = new Jedis("129.204.110.90", 6379);

        // 2. 操作redis
        jedis.auth("xxxx");
        String value = jedis.get("name");
        System.out.println(value);

        // 3. 释放资源
        jedis.close();
    }
}
