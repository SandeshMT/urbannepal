/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Email;
import com.urbannepal.service.EmailService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    //begin of code for saving new email
    private static final String UPLOAD_DIRECTORY = "assets/images";

    @RequestMapping(value = "/savenewemail", method = RequestMethod.POST)
    public ModelAndView displayUsersByRole(@RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {

        String filePath = request.getServletContext().getRealPath("/") + "/assets/images";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        System.out.println(filePath);
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
        Email e = new Email(0, subject, message, fullpath);
        emailService.addEmail(e);

        return new ModelAndView("NewEmail");
    }
    //end of code for adding email

    //start of code for displaying eail
    @RequestMapping(value = "/displayemails", method = RequestMethod.GET)
    public ModelAndView addEmail() {
        List<Email> emails = emailService.displayEmail();
        return new ModelAndView("AllEmail", "emaildetails", emails);
    }
    //end of code for displaying email

    //start of code for editing email
    @RequestMapping(value = "/editemail", method = RequestMethod.GET)
    public ModelAndView editEmail(@RequestParam("eid") int eid) {
        List<Email> email = emailService.displayEmailById(eid);
        return new ModelAndView("EditEmail", "emaildetails", email);
    }
    //end of code for editing email

    //start of code for updating email details
    @RequestMapping(value = "/updateemail", method = RequestMethod.POST)
    public ModelAndView updateEmailDetails(@RequestParam("emaiID") int eid,
            @RequestParam("subject") String subject,
            @RequestParam("message") String content){
        Email e=new Email(eid,subject,content);
        emailService.updateEmailInformation(e);

        List<Email> emails = emailService.displayEmail();
        return new ModelAndView("AllEmail", "emaildetails", emails);
    }
    //end of code for updating email details
    
    //start of code for displaying eail
    @RequestMapping(value = "/deleteemail", method = RequestMethod.GET)
    public ModelAndView deleteEmail(@RequestParam("eid") int eid) {
        emailService.deleteEmail(eid);
        List<Email> emails = emailService.displayEmail();
        return new ModelAndView("AllEmail", "emaildetails", emails);
    }
    //end of code for displaying email
    
    //begin of code for updating post Image only
    @RequestMapping(value = "/updateemailimage", method = RequestMethod.POST)
    public @ResponseBody String updatePostImg(@RequestParam("emailId") int emailId,
            @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {

        String filePath = request.getServletContext().getRealPath("/") + "/assets/images";
        // file.transferTo(new File(filePath + File.separator+file.getOriginalFilename()));
        System.out.println(filePath);
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
        emailService.updateEmailImageOnly(emailId, fullpath);
        System.out.println("");
        return "success";
    }
    //end of code for updating post Image only

}
