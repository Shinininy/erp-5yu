package com.sunline.vuedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunline.vuedemo.dao")
public class VuedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuedemoApplication.class, args);
    }

}
