/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.entity.Tags;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface TagsServiceInterface {
    public void addTag(Tags t);

    public List<Tags> displayTags();
    
    public boolean chaeckTag(String tagname);
}
