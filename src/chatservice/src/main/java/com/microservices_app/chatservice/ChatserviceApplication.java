package com.microservices_app.chatservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.microservices_app.chatservice.**.mapper")
@SpringBootApplication
public class ChatserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatserviceApplication.class, args);
    }

}
