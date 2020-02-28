package com.microservices_app.authservice.modules.user.mapper;

import com.microservices_app.authservice.modules.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IUserMapper {

    User getInfo(int id);

    String login(Map<String, Object> loginFields);

    void signup(@Param("id") String id, @Param("username") String username, @Param("email") String email, @Param("password") String password);

}