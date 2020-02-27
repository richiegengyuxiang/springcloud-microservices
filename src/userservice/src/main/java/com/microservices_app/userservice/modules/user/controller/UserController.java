package com.microservices_app.userservice.modules.user.controller;

import com.microservices_app.userservice.modules.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getInfo() {
        return userService.getInfo(123456).toString();
    }

}

