package com.microservices_app.postservice.modules.post.controller;

import com.microservices_app.postservice.modules.post.entity.Post;
import com.microservices_app.postservice.modules.post.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/getAll")
    public List<Post> getAllPosts() {

//        final String uri = "http://dataprocessingservice:5000";
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        System.out.println(result);
        return postService.getAllPosts();
    }

    @RequestMapping("/getById")
    public Post getById(@RequestBody String id) {
        return postService.getById(id);
    }

    @RequestMapping("/new")
    public void newPost(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description) {

        postService.newPost(name, description);
    }
}
