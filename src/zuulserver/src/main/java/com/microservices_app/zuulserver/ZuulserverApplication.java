package com.microservices_app.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient    // It acts as a eureka client
@EnableZuulProxy        // Enable Zuul
@SpringBootApplication
public class ZuulserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulserverApplication.class, args);
    }

}
