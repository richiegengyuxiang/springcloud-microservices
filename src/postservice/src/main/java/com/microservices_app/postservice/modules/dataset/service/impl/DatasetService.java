package com.microservices_app.postservice.modules.dataset.service.impl;

import com.microservices_app.postservice.modules.dataset.entity.Dataset;
import com.microservices_app.postservice.modules.dataset.mapper.IDatasetMapper;
import com.microservices_app.postservice.modules.dataset.service.IDatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DatasetService implements IDatasetService {

    @Autowired
    private IDatasetMapper datasetMapper;

    @Override
    public List<Dataset> getAllDatasets() {
        return datasetMapper.getAllDatasets();
    }

    @Override
    public List<Dataset> getByRepoId(String id) {
        return datasetMapper.getByRepoId(id);
    }

    @Override
    public Dataset getById(String id) {
        return datasetMapper.getById(id);
    }

    @Override
    public void upload(String description, String dataType, String fileName, String repoId) {

        String id = UUID.randomUUID().toString();
        datasetMapper.upload(id, description, dataType, fileName, repoId);
    }

    @Override
    public String deleteById(String id) {
        try {
            datasetMapper.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally{
            return "deleted";
        }

    }

}
