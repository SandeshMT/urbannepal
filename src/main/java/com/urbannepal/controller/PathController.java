/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class PathController {
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView homepage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/MainDashboard", method = RequestMethod.GET)
    public ModelAndView mainDashboard() {
        return new ModelAndView("MainDashboard");
    }
    
    @RequestMapping(value = "/serviceWizards", method = RequestMethod.GET)
    public ModelAndView serviceWizards() {
        return new ModelAndView("ServiceWizard");
    }
    
    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("Dashboard");
    }

    //redirecting to login page
    @RequestMapping(value = "/un-admin", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("un-LoginPage");
    }
    
     //redirecting to page not found
    @RequestMapping(value = "/pagenotfound", method = RequestMethod.GET)
    public ModelAndView pageNotFound() {
        return new ModelAndView("Page_404");
    }
    
     //redirecting to internal server error
    @RequestMapping(value = "/serverErrpr", method = RequestMethod.GET)
    public ModelAndView internalServerError() {
        return new ModelAndView("Page-500");
    }
    
    //begin of link for media
    //redirecting to media library
    @RequestMapping(value = "/displaymedialibrary", method = RequestMethod.GET)
    public ModelAndView mediaLibrary() {
        return new ModelAndView("MediaGallery");
    }
    
    //redirecting to adding new media
    @RequestMapping(value = "/addmedia", method = RequestMethod.GET)
    public ModelAndView newMedia() {
        return new ModelAndView("NewMedias");
    }
    
    //end of links for media
    
    //begin of links for pages
    //redirecting to newpage
    @RequestMapping(value = "/addpage", method = RequestMethod.GET)
    public ModelAndView newPage() {
        return new ModelAndView("NewPage");
    }
    
    //redirecting to allpage
    @RequestMapping(value = "/displaypages", method = RequestMethod.GET)
    public ModelAndView allPage() {
        return new ModelAndView("AllPages");
    }
    //end of links for pages
    
    //begin of links for Contacts
    
    //redirecting to adding contacts
    @RequestMapping(value = "/addcontact", method = RequestMethod.GET)
    public ModelAndView newContacts() {
        return new ModelAndView("NewContact");
    }
    //end of links for Contacts
    
    //begin of links for services
    
    //redirecting to services catogories
    @RequestMapping(value = "/scategories", method = RequestMethod.GET)
    public ModelAndView serviceCategory() {
        return new ModelAndView("CategoriesS");
    }
    
    //redirecting to services tags
    @RequestMapping(value = "/stags", method = RequestMethod.GET)
    public ModelAndView serviceTags() {
        return new ModelAndView("TagsS");
    }
    //end of links for services
    
    //begin of links for Users    
    //redirecting to all users
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView addUsers() {
        return new ModelAndView("NewUsers");
    }
    //end of links for Users
    
    //begin of links for Profile
    //redirecting to view Profile
    @RequestMapping(value = "/userprofile", method = RequestMethod.GET)
    public ModelAndView userProfile() {
        return new ModelAndView("Profile");
    }
    //end of links for Profile    
    
    //begin of links for Email  
    @RequestMapping(value = "/addemail", method = RequestMethod.GET)
    public ModelAndView addEmail() {
        return new ModelAndView("NewEmail");
    }
    //end of links for Users
    
}