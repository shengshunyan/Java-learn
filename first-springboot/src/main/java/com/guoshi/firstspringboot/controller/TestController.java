package com.guoshi.firstspringboot.controller;

import com.guoshi.firstspringboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private User user;

    @GetMapping("/test")
    public String test() {
        return "hello springboot";
    }

    @GetMapping("/user")
    public User user() {
        return user;
    }
}
