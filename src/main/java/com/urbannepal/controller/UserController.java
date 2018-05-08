/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Contacts;
import com.urbannepal.entity.Email;
import com.urbannepal.entity.Subscribers;
import com.urbannepal.entity.User;
import com.urbannepal.service.ContactService;
import com.urbannepal.service.EmailService;
import com.urbannepal.service.UserService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class UserController {
    @Autowired
    ContactService contactService;

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    EmailService emailService;

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    private int contactId=0;
    private static final String UPLOAD_DIRECTORY = "assets/images";

    @RequestMapping(value = "/newprofessional", method = RequestMethod.POST)
    public ModelAndView submitAddProduct(@RequestParam("username") String username,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("primarynumber") String primarynumber,
            @RequestParam("secondarynumber") String secondarynumber,
            @RequestParam("primaryaddress") String primaryaddress,
            @RequestParam("secondaryaddress") String secondaryaddress,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("biography") String biography,
            @RequestParam("profession") String profession,
            @RequestParam("gender") String gender,
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
        Contacts c = new Contacts(0, fullpath, firstname, lastname, primarynumber, secondarynumber, primaryaddress, secondaryaddress, gender, email, profession);
        try {
            contactId = contactService.addAndGetNewId(c);
        } catch (Exception e) {
            System.out.println("failed to get max id");
        }
        System.out.println("Maximum Contact ID: " + contactId);
        String role = "ROLE_USER";
        int status=1;
        User u = new User(0, fullpath, username, firstname, lastname, email, password,status, biography, role, contactId);
        userService.addUsers(u);
        return new ModelAndView("redirect:displayusers");
    }
    //begin of code for displaying users
    //redirecting to all users
    @RequestMapping(value = "/displayusers", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> userdtls=userService.displayUsers();
        return new ModelAndView("AllUsers","userdetails",userdtls);
    }
    //end of code for displaying users
    
    //begin of code for displaying users by Role
    //redirecting to all users
    @RequestMapping(value = "/displayByRole", method = RequestMethod.GET)
    public ModelAndView displayUsersByRole(@RequestParam("ur") int urole) {
        List<User> userdtls=userService.displayUserByRole(urole);
        return new ModelAndView("AllUsers","userdetails",userdtls);
    }
    //end of code for displaying users
    
    //begin of code for profile
    @RequestMapping(value = "/viewprofile", method = RequestMethod.GET)
    public String viewProfile(@RequestParam("uid") int uid,
            @RequestParam("cid") int cid,ModelMap model) {
        List<User> userdtls=userService.displayUserById(uid);
        List<Contacts> conts=contactService.displayContactsById(cid);
        model.addAttribute("userdetails", userdtls);
        model.addAttribute("contactdetails", conts);
        return "Profile";
    }
    //end of code for displaying profile
    
     //begin of code for subscriber
    @RequestMapping(value = "/subscriber", method = RequestMethod.POST)
    public String subscriber(@RequestParam("email") String email) {
        String status="subscribed";
        Subscribers subs=new Subscribers(0,email,status);
        userService.newSubscriber(subs);
        
        //begin of code for sending first email to subscriber
        String subject="Subscriber";
        List<Email> subsemail= emailService.getEmailBySubject(subject);
        String conts="";
        String path="";
        for(Email e: subsemail){
            conts=e.getContent();
            path=e.getFeaturedImage();
        }
        
        //String to = "suman.thapa1605@gmail.com  ";//change accordingly  
        final String username = "nepbagz@gmail.com";//change accordingly  
        final String password = "nepbagz2016";//change accordingly 

        //getting properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //getting session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {
            //compose message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));

            message.setSubject("HTML Message with attachment from database");

            //creating MimeBodyPart object and setting text message  
//            BodyPart htmlcont2=new MimeBodyPart();
//            htmlcont2.setContent("<h2>Dear &nbsp;"+ email+"</h2>","text/html");
            BodyPart htmlcont = new MimeBodyPart();
            //htmlcont.setText("Dear &nbsp;"+ email);
            //htmlcont.setContent("<h1>This is heading 1</h1><p>this is paragraph</p>","text/html");
            htmlcont.setContent("<h2>Dear &nbsp;"+ email+"</h2><br/><br/>"
                    +conts,"text/html");

            //creating new MimeBodyPart object and setting DataHandler object to this object      
            MimeBodyPart attachment = new MimeBodyPart();

            String filename = "C:/Users/myhp/Documents/NetBeansProjects/urbannepal/src/main/webapp/"+path;//change accordingly  
            DataSource source = new FileDataSource(filename);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(filename);

            //creating Multipart object and adding MimeBodyPart objects to this object      
            Multipart multipart = new MimeMultipart();
            //multipart.addBodyPart(htmlcont2);
            multipart.addBodyPart(htmlcont);
            multipart.addBodyPart(attachment);

            // setting the multiplart object to the message object  
            message.setContent(multipart);
        //message.setContent("<h1>sending html mail check</h1>","text/html" );  

            //sending message
            Transport.send(message);
            System.out.println("message sent....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        //end of code for sending first email to subscriber
        return "Thank you for subscribing us.";
    }
    //end of code for subscriber
    
    //begin of code for displaying user information for edit
    @RequestMapping(value = "/editUserInfo", method = RequestMethod.GET)
    public String displayUserForEdit(@RequestParam("euid") int uid,
            @RequestParam("cid") int cid,ModelMap model) {
        List<User> userdtls=userService.displayUserById(uid);
        List<Contacts> conts=contactService.displayContactsById(cid);
        model.addAttribute("userdetails", userdtls);
        model.addAttribute("contactdetails", conts);
        return "EditUserInfo";
    }
    //end of code for displaying user information for edit
    
    //begin of code for updating user's Image only
    @RequestMapping(value = "/updatesrandcontimage", method = RequestMethod.POST)
    public @ResponseBody String updatePostImg(@RequestParam("userId") int userId,
            @RequestParam("contactId") int contactId,
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
        userService.updateUsrProfilePic(userId, fullpath);
        contactService.updateProfilePic(contactId, fullpath);
        return "success";
    }
    //end of code for updating user's Image only
    
    //begin of code for deleting user information
    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
    public ModelAndView deleteUserInformation(@RequestParam("duid") int uid,
            @RequestParam("cid") int cid) {
        userService.deleteUser(uid);
        contactService.deleteContact(cid);
        List<User> userdtls=userService.displayUsers();
        return new ModelAndView("AllUsers","userdetails",userdtls);
    }
    //end of code for deleting user information
    
    //begin of code for deleting user information
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ModelAndView updateUserInformation(@RequestParam("userId") int uid,
            @RequestParam("username") String username,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            @RequestParam("biographicalInformation") String biographicalInformation,
            @RequestParam("profession") String profession,
            @RequestParam("primaryNum") String primaryNum,
            @RequestParam("secondaryNum") String secondaryNum,
            @RequestParam("paddress") String paddress,
            @RequestParam("saddress") String saddress,
            @RequestParam("gender") String gender,
            @RequestParam("contId") int cid) {
        int status=1;
        User u=new User(uid,username,firstname,lastname,email,status,biographicalInformation,role,cid);
        Contacts c=new Contacts(cid,firstname,lastname,primaryNum,secondaryNum,paddress,saddress,gender,email,profession);
        userService.updateUserInformation(u);
        contactService.updateContact(c);
        List<User> userdtls=userService.displayUsers();
        return new ModelAndView("AllUsers","userdetails",userdtls);
    }
    //end of code for deleting user information

}
