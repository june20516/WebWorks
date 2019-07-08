package com.bit.juniver.model.service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit.juniver.model.dto.UploadFile;
import com.bit.juniver.util.UploadFileUtils;


@Service
public class ImageService {
    
    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);
    
    private final Path rootLocation;
    
    public ImageService() {
        this.rootLocation = Paths.get("/resources/images/");
    }
    
    
    public Resource loadAsResource(String fileName) throws Exception {
        try {
            if (fileName.toCharArray()[0] == '/') {
                fileName = fileName.substring(1);
            }
            
            Path file = loadPath(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new Exception("Could not read file: " + fileName);
            }
        } catch (Exception e) {
            throw new Exception("Could not read file: " + fileName);
        }
    }
    
    private Path loadPath(String fileName) {
        return rootLocation.resolve(fileName);
    }
    
    public UploadFile store(MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) {
                throw new Exception("Failed to store empty file " + file.getOriginalFilename());
            }
            
            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString(), file);
            
            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }
            System.out.println("파일 이름까지는 저장이 되었나보다 ");
            
            Resource resource = loadAsResource(saveFileName);
            System.out.println("파일 리소스를 불러왔나보다 ");
            
            UploadFile saveFile = new UploadFile();
            saveFile.setSaveFileName(saveFileName);
            saveFile.setFileName(file.getOriginalFilename());
            saveFile.setContentType(file.getContentType());
            saveFile.setFilePath(rootLocation.toString().replace(File.separatorChar, '/') + File.separator + saveFileName);
            saveFile.setSize(resource.contentLength());
            saveFile.setRegDate(new Date());
            System.out.println("여기까지면 ㅍ ㅏ일은 받았다 !" + saveFile.getFilePath());
            return saveFile;
        } catch (IOException e) {
            throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}