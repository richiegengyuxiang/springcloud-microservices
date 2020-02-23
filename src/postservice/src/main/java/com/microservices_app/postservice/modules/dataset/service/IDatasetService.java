package com.microservices_app.postservice.modules.dataset.service;

import com.microservices_app.postservice.modules.dataset.entity.Dataset;

import java.util.List;

public interface IDatasetService {

    List<Dataset> getAllDatasets();

    List<Dataset> getByPostId(String id);

    Dataset getById(String id);

    void upload(String description, String dataType, String fileName, String id);

    String deleteById(String id);
}
