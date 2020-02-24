package com.microservices_app.chatservice.modules.chat.entity;

import lombok.Data;

@Data
public class Chat {
    private String id;
    private String from;
    private String to;
    private String message;
}