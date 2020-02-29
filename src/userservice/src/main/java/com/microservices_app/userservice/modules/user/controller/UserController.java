package com.microservices_app.userservice.modules.user.controller;

import com.microservices_app.userservice.modules.user.entity.User;
import com.microservices_app.userservice.modules.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfoByJwt")
    public User getUserInfoByJwt(@RequestBody String jwt) {
        return userService.getUserInfoByJwt(jwt);
    }

}

