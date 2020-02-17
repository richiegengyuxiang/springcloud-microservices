package com.microservices_app.userservice.modules.user.controller;

import com.microservices_app.userservice.modules.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String foo(){

        final String uri = "http://localhost:5000";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);

        return "User service";
    }

    public String getInfo(){
        return userService.getInfo(1).toString();
    }
}

