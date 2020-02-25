package com.microservices_app.postservice.modules.post.service;

import com.microservices_app.postservice.modules.post.entity.Post;

import java.util.List;

public interface IPostService {

    Post getById(String id);

    List<Post> getAllPosts();

    void newPost(String name, String description);
}
