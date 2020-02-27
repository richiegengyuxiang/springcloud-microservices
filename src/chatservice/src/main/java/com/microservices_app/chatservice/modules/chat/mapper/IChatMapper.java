package com.microservices_app.chatservice.modules.chat.mapper;

import com.microservices_app.chatservice.modules.chat.entity.Chat;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatMapper {

    Chat getInfo(int id);
}