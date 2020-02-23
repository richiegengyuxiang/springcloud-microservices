package com.microservices_app.postservice.modules.dataset.controller;

import com.microservices_app.postservice.modules.dataset.entity.Dataset;
import com.microservices_app.postservice.modules.dataset.service.impl.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/datasets/")
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    public static String storagePath = "/storage/";

    @RequestMapping("/getAll")
    public List<Dataset> getAllDatasets() {
        return datasetService.getAllDatasets();
    }

    @RequestMapping("/getByPostId")
    public List<Dataset> getByPostId(@RequestBody String id) {
        return datasetService.getByPostId(id);
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestBody String id) {

        Dataset dataset = datasetService.getById(id);
        String dataType = dataset.getType();
        String fileName = dataset.getName();
        File file = new File(storagePath + dataType + "/" + fileName);
        file.delete();

        return datasetService.deleteById(id);
    }

    @RequestMapping("/upload")
    public void uploadDataset(@RequestParam(name = "file") MultipartFile file,
                              @RequestParam(name = "postId") String postId,
                              @RequestParam(name = "description") String description) throws IOException {

        String fileName = file.getOriginalFilename();
        String dataType = FilenameUtils.getExtension(fileName);
        if (dataType.equals("")) {
            dataType = "txt";
        }

        String directoryPath = storagePath + dataType;
        String filePath = directoryPath + "/" + fileName;
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            directory.mkdir();
        }
        File uploadFile = new File(filePath);

        try {
            file.transferTo(uploadFile);
            datasetService.upload(description, dataType, fileName, postId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/fileDownload/{id}")
    public void downloadCSVById(@PathVariable("id") String id, HttpServletResponse response) throws IOException {

        Dataset dataset = datasetService.getById(id);
        String dataType = dataset.getType();
        String fileName = dataset.getName();
        System.out.println("changed");

        File file = new File(storagePath + dataType + "/" + fileName);
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(file);

        response.addHeader("Content-disposition", "attachment;fileName=" + fileName);

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }
}
