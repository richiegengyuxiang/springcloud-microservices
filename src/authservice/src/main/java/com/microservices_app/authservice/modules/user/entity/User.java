package com.microservices_app.authservice.modules.user.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String email;
    private String password;
}

