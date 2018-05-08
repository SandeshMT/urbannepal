/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.entity.Categories;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface CategoriesServiceInterface {
    public void addCategory(Categories c);

    public List<Categories> displayCategory();
    
    public boolean chaeckCategory(String catname);
    
    public List<Categories> displayCategoryName();
}
