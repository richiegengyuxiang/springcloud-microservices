package com.microservices_app.postservice.modules.repo.service;

import com.microservices_app.postservice.modules.repo.entity.Repo;

import java.util.List;

public interface IRepoService {

    Repo getById(String id);

    List<Repo> getAllRepos();

    void newRepo(String name, String description);
}
