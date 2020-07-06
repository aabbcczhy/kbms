package com.fjnu.kbms.controller;
import com.fjnu.kbms.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@org.springframework.web.bind.annotation.RestController
public class PhotoController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    @RequestMapping("/upload")
    public Response upload(MultipartFile file) throws java.io.IOException {
        String newName = java.util.UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new java.io.File(newName));
        return Response.create(newName);
    }

    @RequestMapping("**/image/{fileName:.+}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String fileName){
        try{
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPath + "/" + fileName));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
