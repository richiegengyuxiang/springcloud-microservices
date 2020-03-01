package com.microservices_app.userservice.modules.user.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String bio;
}

