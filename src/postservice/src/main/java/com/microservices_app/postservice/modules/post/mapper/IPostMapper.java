package com.microservices_app.postservice.modules.post.mapper;

import com.microservices_app.postservice.modules.post.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostMapper {

    Post getById(String id);

    List<Post> getAllPosts();

    void newPost(String id, String name, String description);
}
