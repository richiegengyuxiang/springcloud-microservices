package com.microservices_app.postservice.modules.repo.controller;

import com.microservices_app.postservice.modules.repo.entity.Repo;
import com.microservices_app.postservice.modules.repo.service.impl.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/repos/")
public class RepoController {

    @Autowired
    private RepoService repoService;

    @RequestMapping("/getAll")
    public List<Repo> getAllRepos(){

        final String uri = "http://dataprocessingservice:5000";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);

        return repoService.getAllRepos();
    }

    @RequestMapping("/getById")
    public Repo getById(@RequestBody String id){
        return repoService.getById(id);
    }

    @RequestMapping("/new")
    public void newRepo(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description) {

        repoService.newRepo(name, description);
    }
}
