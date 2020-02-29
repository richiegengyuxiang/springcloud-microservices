package com.microservices_app.userservice.modules.user.service;

import com.microservices_app.userservice.modules.user.entity.User;

public interface IUserService {
    User getUserInfoByJwt(String jwt);
}
