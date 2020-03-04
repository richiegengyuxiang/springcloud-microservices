package com.microservices_app.postservice.modules.document.service.impl;

import com.microservices_app.postservice.modules.document.entity.Document;
import com.microservices_app.postservice.modules.document.mapper.IDocumentMapper;
import com.microservices_app.postservice.modules.document.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    private IDocumentMapper documentMapper;

    @Override
    public List<Document> getAllDocuments() {
        return documentMapper.getAllDocuments();
    }

    @Override
    public List<Document> getByPostId(String id) {
        return documentMapper.getByPostId(id);
    }

    @Override
    public Document getById(String id) {
        return documentMapper.getById(id);
    }

    @Override
    public void storeDocument(Map<String, Object> documentBody) {

        String id = UUID.randomUUID().toString();

        Document document = new Document();
        document.setId(id);
        document.setContent((String) documentBody.get("content"));
        document.setPostId((String) documentBody.get("postId"));
        documentMapper.storeDocument(document.getId(), document.getContent(), document.getPostId());
    }

}
