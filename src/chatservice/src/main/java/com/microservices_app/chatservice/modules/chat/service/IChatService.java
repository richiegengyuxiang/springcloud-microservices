package com.microservices_app.chatservice.modules.chat.service;

import com.microservices_app.chatservice.modules.chat.entity.Chat;

public interface IChatService {
    Chat getInfo(int id);
}
