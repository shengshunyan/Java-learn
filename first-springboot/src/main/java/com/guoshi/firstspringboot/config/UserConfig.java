package com.guoshi.firstspringboot.config;

import com.guoshi.firstspringboot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 代表当前类是一个配置类
public class UserConfig {
    @Bean       // 构建一个实例，并放到spring容器中
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }
}
