package com.microservices_app.postservice.modules.document.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Document {
    private String id;
    private String content;
    private String postId;
}
