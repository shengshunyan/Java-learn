package com.guoshi.test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Demo3 {
    @Test
    // redis连接池
    public void pool() {
        // 1. 创建连接池
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(100); // 连接池中最大活跃数
        poolConfig.setMaxIdle(10); // 最大空闲数
        poolConfig.setMinIdle(5); // 最小空闲数
        poolConfig.setMaxWaitMillis(3000); // 当连接池空了之后，多久没货渠道jedis对象，就超时
        JedisPool pool = new JedisPool(poolConfig, "129.204.110.90", 6379, 3000, "xxxx");
        // 2. 通过连接池获取jedis对象
        Jedis jedis = pool.getResource();
        // 3. 操作
        String value = jedis.get("name");
        System.out.println(value);
        // 4. 释放资源(还给连接池)
        jedis.close();
    }
}
