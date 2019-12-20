package com.example.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * desc: 程序启动入口类
 * author: sadcoder333
 * date: 2019/10/1
 **/
@SpringBootApplication
public class SpringbootappApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootappApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootappApplication.class, args);
    }

}
