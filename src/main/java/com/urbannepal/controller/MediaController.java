/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Media;
import com.urbannepal.service.MediaService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class MediaController {
    @Autowired
    MediaService mediaService;

    public MediaService getMediaService() {
        return mediaService;
    }

    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    private static final String UPLOAD_DIRECTORY="assets/images";
    //begin of code for inserting media
    @RequestMapping(value = "/uploadmedias", method = RequestMethod.POST)
    public ModelAndView submitAddProduct(
            @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {
        
        String filePath = request.getServletContext().getRealPath("/") + "/assets/images";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        String filename = file.getOriginalFilename();
        filePath = filePath.replaceAll("\\\\", "/");

        System.out.println(filePath + "/" + filename);

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(filePath + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        String fullpath = UPLOAD_DIRECTORY + "/" + filename;
        Media m=new Media(0,fullpath);
        mediaService.addMedia(m);
        System.out.println("Image Name for Upload:="+fullpath);
        return new ModelAndView("redirect:AddProduct");
    }
    
}
