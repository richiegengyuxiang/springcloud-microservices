package com.microservices_app.authservice.modules.user.service.impl;

import com.microservices_app.authservice.modules.user.entity.User;
import com.microservices_app.authservice.modules.user.mapper.IUserMapper;
import com.microservices_app.authservice.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User getInfo(int id) {
        return userMapper.getInfo(id);
    }

    @Override
    public String signup(Map<String, Object> signupField) {
        System.out.println(signupField);
        return userMapper.signup(signupField);
    }

    @Override
    public String login(Map<String, Object> loginFields) {
        return userMapper.login(loginFields);
    }
}
