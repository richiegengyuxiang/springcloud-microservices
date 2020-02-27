package com.microservices_app.authservice.modules.user.service;

import com.microservices_app.authservice.modules.user.entity.User;

public interface IUserService {
    User getInfo(int id);

    String login();
}
