package com.microservices_app.userservice.modules.user.service.impl;

import com.microservices_app.userservice.modules.user.entity.User;
import com.microservices_app.userservice.modules.user.mapper.IUserMapper;
import com.microservices_app.userservice.modules.user.service.IUserService;
import com.microservices_app.userservice.modules.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User getUserInfoByJwt(String jwt) {
        String username = jwtUtil.extractUsername(jwt);

        User user = loadUserByUsername(username);
        System.out.println(user);
        if (jwtUtil.validateToken(jwt, user)) {
            return user;
        }
        ;
        return null;
    }

    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }
}
