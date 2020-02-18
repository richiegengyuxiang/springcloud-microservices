package com.microservices_app.postservice.modules.repo.mapper;

import com.microservices_app.postservice.modules.repo.entity.Repo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepoMapper {

    Repo getById(String id);

    List<Repo> getAllRepos();

    void newRepo(String id, String name, String description);
}
