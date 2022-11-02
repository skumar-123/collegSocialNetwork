package com.social.network.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class ImageUploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String imageUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("C:/work/" + file.getOriginalFilename());
        convertFile.createNewFile();
        try {
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "file uploaded successfully";
    }
}
