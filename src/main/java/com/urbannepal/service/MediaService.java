/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.MediaDao;
import com.urbannepal.entity.Media;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class MediaService implements MediaServiceInterface{
    @Autowired
    MediaDao mdao;

    public MediaDao getMdao() {
        return mdao;
    }

    public void setMdao(MediaDao mdao) {
        this.mdao = mdao;
    }
    

    @Transactional
    @Override
    public void addMedia(Media m) {
        mdao.addMedia(m);
    }

    @Override
    public List<Media> displayMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editMedia(int mid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
