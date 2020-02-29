package com.microservices_app.authservice.modules.user.mapper;

import com.microservices_app.authservice.modules.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IUserMapper {

    User login(String email, String password);

    User checkIfEmailExists(String email);

    void signup(String id, String username, String email, String password);

    User checkIfUsernameExists(String username);
}