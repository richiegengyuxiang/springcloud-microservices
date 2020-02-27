package com.microservices_app.authservice.modules.user.service;

import com.microservices_app.authservice.modules.user.entity.User;

import java.util.Map;

public interface IUserService {
    User getInfo(int id);

    String signup(Map<String, Object> signupField);

    String login(Map<String, Object> loginFields);
}
