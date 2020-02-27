package com.microservices_app.userservice.modules.user.service.impl;

import com.microservices_app.userservice.modules.user.entity.User;
import com.microservices_app.userservice.modules.user.mapper.IUserMapper;
import com.microservices_app.userservice.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public User getInfo(int id) {
        return userMapper.getInfo(id);
    }
}
