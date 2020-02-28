package com.microservices_app.authservice.modules.user.service.impl;

import com.microservices_app.authservice.modules.user.entity.User;
import com.microservices_app.authservice.modules.user.mapper.IUserMapper;
import com.microservices_app.authservice.modules.user.service.IUserService;
import com.microservices_app.authservice.modules.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User getInfo(int id) {
        return userMapper.getInfo(id);
    }

    @Override
    public String signup(Map<String, Object> signupField) {
        User user = new User();

        String id = UUID.randomUUID().toString();
        user.setId(id);
        String username = (String) signupField.get("username");
        user.setUsername(username);
        String email = (String) signupField.get("email");
        user.setEmail(email);
        String password = (String) signupField.get("password");
        user.setPassword(password);

        try {
            userMapper.signup(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            String jwt = jwtUtil.generateToken(user);
            return jwt;
        }

    }

    @Override
    public String login(Map<String, Object> loginFields) {
        return userMapper.login(loginFields);
    }
}
