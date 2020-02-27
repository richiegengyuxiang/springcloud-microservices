package com.microservices_app.authservice.modules.user.mapper;

import com.microservices_app.authservice.modules.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IUserMapper {

    User getInfo(int id);

    String login(Map<String, Object> loginFields);

    String signup(Map<String, Object> signupField);
}