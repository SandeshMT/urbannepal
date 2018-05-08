/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Tags;
import com.urbannepal.service.TagsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myhp
 */
@Controller
public class TagsController {
    @Autowired
    TagsService tagsService;

    public TagsService getTagsService() {
        return tagsService;
    }

    public void setTagsService(TagsService tagsService) {
        this.tagsService = tagsService;
    }
    
    //    begin of code for inserting category details
        @RequestMapping(value = "/submittagsdetails", method = RequestMethod.POST)
    public ModelAndView addBooks(@RequestParam("tagsname") String tagsname,
            @RequestParam("slug") String slug,
            @RequestParam("description") String description
    ) {
            Tags t=new Tags(0, tagsname, slug, description);
            tagsService.addTag(t);
            return new ModelAndView("redirect:ptags");
       
    }
//    end of code for inserting category details
    
    //begin of code for displaying tags
    //redirecting to tags
    @RequestMapping(value = "/ptags", method = RequestMethod.GET)
    public ModelAndView tags() {
        List<Tags> tags=tagsService.displayTags();
        return new ModelAndView("Tags", "tagsdetails", tags);
    }
    //end of code for displaying tags
}
