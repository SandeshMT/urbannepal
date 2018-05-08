/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Contacts;
import com.urbannepal.service.ContactService;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }
    
    private static final String UPLOAD_DIRECTORY="assets/images";
    @RequestMapping(value = "/savenewcontact", method = RequestMethod.POST)
    public ModelAndView submitAddProduct(@RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("primarynumber") String primarynumber,
            @RequestParam("secondarynumber") String secondarynumber,
            @RequestParam("primaryaddress") String primaryaddress,
            @RequestParam("secondaryaddress") String secondaryaddress,
            @RequestParam("email") String email,
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
        Contacts conts=new Contacts(0,fullpath,firstname,lastname, primarynumber, secondarynumber, primaryaddress, secondaryaddress,gender,email,profession);
        contactService.addContact(conts);
        return new ModelAndView("redirect:addcontact");
    }
    
    
    //redirecting to all contacts
    @RequestMapping(value = "/displaycontacts", method = RequestMethod.GET)
    public ModelAndView allContacts() {
        List<Contacts> conts=contactService.displayContacts();
        return new ModelAndView("AllContacts", "contactdetails", conts);
    }
    
    //redirecting to contacts searched via initial words
    @RequestMapping(value = "/displaycontact", method = RequestMethod.GET)
    public ModelAndView displaySpecificWordContacts(@RequestParam("src") String searchvalue) {
        List<Contacts> conts=contactService.displayContactsByInitialWord(searchvalue);
        return new ModelAndView("AllContacts", "contactdetails", conts);
    }
    
    //redirecting to contacts searched via contactid
    @RequestMapping(value = "/viewspecificontact", method = RequestMethod.GET)
    public ModelAndView displayContactsById(@RequestParam("cid") int searchvalue) {
        List<Contacts> conts=contactService.displayContactsById(searchvalue);
        return new ModelAndView("AllContacts", "contactdetails", conts);
    }
}
