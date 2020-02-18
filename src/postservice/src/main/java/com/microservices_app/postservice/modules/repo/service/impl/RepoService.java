package com.microservices_app.postservice.modules.repo.service.impl;

import com.microservices_app.postservice.modules.repo.entity.Repo;
import com.microservices_app.postservice.modules.repo.mapper.IRepoMapper;
import com.microservices_app.postservice.modules.repo.service.IRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RepoService implements IRepoService {

    @Autowired
    private IRepoMapper repoMapper;

    @Override
    public Repo getById(String id) {
        return repoMapper.getById(id);
    }

    @Override
    public List<Repo> getAllRepos() {
        return repoMapper.getAllRepos();
    }

    @Override
    public void newRepo(String name, String description) {
        String id = UUID.randomUUID().toString();
        repoMapper.newRepo(id, name, description);
    }
}
