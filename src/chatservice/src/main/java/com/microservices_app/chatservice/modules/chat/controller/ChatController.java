package com.microservices_app.chatservice.modules.chat.controller;

import com.microservices_app.chatservice.modules.chat.service.impl.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping("/")
    public String getInfo() {

//        return chatService.getInfo(123456).toString();
        return "chat";
    }
}

