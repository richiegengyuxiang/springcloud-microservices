package com.microservices_app.chatservice.modules.chat.service.impl;

import com.microservices_app.chatservice.modules.chat.entity.Chat;
import com.microservices_app.chatservice.modules.chat.mapper.IChatMapper;
import com.microservices_app.chatservice.modules.chat.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements IChatService {
    @Autowired
    private IChatMapper chatMapper;

    @Override
    public Chat getInfo(int id) {
        return chatMapper.getInfo(id);
    }
}
