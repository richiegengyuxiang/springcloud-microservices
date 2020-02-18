package com.microservices_app.postservice.modules.dataset.mapper;

import com.microservices_app.postservice.modules.dataset.entity.Dataset;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatasetMapper {

    List<Dataset> getAllDatasets();

    List<Dataset> getByRepoId(String id);

    Dataset getById(String id);

    void upload(String id, String description, String dataType, String fileName, String repoId);

    void deleteById(String id);
}
