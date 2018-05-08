/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import com.urbannepal.entity.Categories;
import com.urbannepal.service.CategoriesService;
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
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    
//    begin of code for inserting category details
        @RequestMapping(value = "/submitcatdetails", method = RequestMethod.POST)
    public ModelAndView addBooks(@RequestParam("categoryname") String catname,
            @RequestParam("slug") String slug,
            @RequestParam("parent") String parent,
            @RequestParam("description") String description
    ) {
            Categories cat=new Categories(0, catname, slug, parent, description);
            categoriesService.addCategory(cat);
            return new ModelAndView("redirect:pcategories");
       
    }
//    end of code for inserting category details
    
    //begin of code for redirecting to categories page and displaying categories 
    @RequestMapping(value = "/pcategories", method = RequestMethod.GET)
    public ModelAndView categories() {
        List<Categories> c=categoriesService.displayCategory();
        return new ModelAndView("CategoriesP", "catdetails", c);
    }
    //end of code for redirecting to categories page and displaying categories 
    
}
