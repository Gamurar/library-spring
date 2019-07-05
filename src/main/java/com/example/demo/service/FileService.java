package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String convertFileToBase64(String filePath);

    void saveFile(MultipartFile file);

}
