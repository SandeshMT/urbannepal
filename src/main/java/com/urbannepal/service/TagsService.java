/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.TagsDao;
import com.urbannepal.entity.Tags;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class TagsService implements TagsServiceInterface{
    @Autowired
    TagsDao tdao;

    public TagsDao getTdao() {
        return tdao;
    }

    public void setTdao(TagsDao tdao) {
        this.tdao = tdao;
    }
    

    @Transactional
    @Override
    public void addTag(Tags t) {
       tdao.addTag(t);
    }

    @Transactional
    @Override
    public List<Tags> displayTags() {
        return tdao.displayTags();
    }

    @Override
    public boolean chaeckTag(String tagname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
