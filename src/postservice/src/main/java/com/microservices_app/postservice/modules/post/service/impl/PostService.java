package com.microservices_app.postservice.modules.post.service.impl;

import com.microservices_app.postservice.modules.post.entity.Post;
import com.microservices_app.postservice.modules.post.mapper.IPostMapper;
import com.microservices_app.postservice.modules.post.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostMapper postMapper;

    @Override
    public Post getById(String id) {
        return postMapper.getById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.getAllPosts();
    }

    @Override
    public void newPost(String name, String description) {
        String id = UUID.randomUUID().toString();
        postMapper.newPost(id, name, description);
    }
}
