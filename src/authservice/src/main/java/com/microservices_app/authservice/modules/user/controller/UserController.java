package com.microservices_app.authservice.modules.user.controller;

import com.microservices_app.authservice.modules.user.entity.User;
import com.microservices_app.authservice.modules.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody Map<String, Object> loginFields) {
        System.out.println(loginFields);
//        return userService.login();
        return null;
    }
}

