package com.microservices_app.postservice.modules.document.controller;

import com.microservices_app.postservice.modules.document.entity.Document;
import com.microservices_app.postservice.modules.document.service.impl.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/documents/")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/storeDocument")
    public void storeDocument(@RequestBody Map<String, Object> documentBody) {
        documentService.storeDocument(documentBody);
    }

    @RequestMapping("/getAll")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @RequestMapping("/getByPostId")
    public List<Document> getByPostId(@RequestBody String id) {
        return documentService.getByPostId(id);
    }
}
