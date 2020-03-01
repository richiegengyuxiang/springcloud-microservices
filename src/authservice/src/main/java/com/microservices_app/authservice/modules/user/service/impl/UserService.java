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
    public String signup(Map<String, Object> signupField) {
        User user = new User();

        String id = UUID.randomUUID().toString();
        String username = (String) signupField.get("username");
        String email = (String) signupField.get("email");
        String password = (String) signupField.get("password");
        String passwordEncoded = passwordEncoder.encode(password);

        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoded);

        if (userMapper.checkIfEmailExists(email) != null) {
            return "The email already exists";
        }

        if (userMapper.checkIfUsernameExists(username) != null) {
            return "The username already exists";
        }

        try {
            userMapper.signup(id, username, email, passwordEncoded);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            String jwt = jwtUtil.generateToken(user);
            return jwt;
        }

    }

    @Override
    public String login(Map<String, Object> loginFields) {

        String email = (String) loginFields.get("email");
        String password = (String) loginFields.get("password");

        User user = new User();
        try {
            user = userMapper.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (passwordEncoder.matches(password, user.getPassword()) == true) {
                String jwt = jwtUtil.generateToken(user);
                return jwt;
            }

            return "failure";
        }
    }
}
