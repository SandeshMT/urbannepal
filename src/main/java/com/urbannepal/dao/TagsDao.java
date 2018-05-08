/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Tags;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myhp
 */
@Repository
public class TagsDao implements TagsDaoInterface {
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    public void addTag(Tags t) {
        Session sess = sessionFactory.openSession();
        sess.save(t);
        sess.close();
    }

    @Override
    public List<Tags> displayTags() {
        Session sess = sessionFactory.openSession();
        //Query query = sessionFactory.getCurrentSession().createQuery("FROM Tags");
        List<Tags> tag = sess.createCriteria(Tags.class).list();
        //System.out.println(tag);
        sess.close();
        return tag;
    }

    @Override
    public boolean chaeckTag(String tagname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
