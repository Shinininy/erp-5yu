package com.example.sdorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sdorder.mapper")
public class SdorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdorderApplication.class, args);
    }

}
