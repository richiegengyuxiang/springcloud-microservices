package com.microservices_app.postservice.modules.document.mapper;

import com.microservices_app.postservice.modules.document.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDocumentMapper {

    List<Document> getAllDocuments();

    List<Document> getByPostId(String id);

    Document getById(String id);

    void storeDocument(String id, String content, String postId);
}
