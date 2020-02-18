package com.microservices_app.userservice.modules.profile.entity;

import lombok.Data;

@Data
public class Profile {
    private String id;
    private String username;
    private String email;
    private String password;
}