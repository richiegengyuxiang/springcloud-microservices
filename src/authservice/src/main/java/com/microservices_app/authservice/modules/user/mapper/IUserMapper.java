package com.microservices_app.authservice.modules.user.mapper;

import com.microservices_app.authservice.modules.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper {

    User getInfo(int id);

    String login();
}