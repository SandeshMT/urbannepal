/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.CategoriesDao;
import com.urbannepal.entity.Categories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class CategoriesService implements CategoriesServiceInterface{
    @Autowired
    CategoriesDao catdao;

    public CategoriesDao getCatdao() {
        return catdao;
    }

    public void setCatdao(CategoriesDao catdao) {
        this.catdao = catdao;
    }
    

    @Transactional
    @Override
    public void addCategory(Categories c) {
        catdao.addCategory(c);
    }

    @Transactional
    @Override
    public List<Categories> displayCategory() {
        return catdao.displayCategory();
    }

    @Override
    public boolean chaeckCategory(String catname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<Categories> displayCategoryName() {
        return catdao.displayCategoryName();
    }
    
    
}
