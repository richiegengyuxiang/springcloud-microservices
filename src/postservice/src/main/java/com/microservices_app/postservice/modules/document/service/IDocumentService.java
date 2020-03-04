package com.microservices_app.postservice.modules.document.service;

import com.microservices_app.postservice.modules.document.entity.Document;

import java.util.List;
import java.util.Map;

public interface IDocumentService {

    List<Document> getAllDocuments();

    List<Document> getByPostId(String id);

    Document getById(String id);

    void storeDocument(Map<String, Object> documentBody);
}
