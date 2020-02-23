package com.microservices_app.postservice.modules.post.entity;

import lombok.Data;

@Data
public class Post {

    private String id;
    private String name;
    private String description;
}
