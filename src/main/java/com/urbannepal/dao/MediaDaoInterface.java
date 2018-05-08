/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Media;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface MediaDaoInterface {
    public void addMedia(Media m);

    public List<Media> displayMedia();
    
    public boolean editMedia(int mid);
}
