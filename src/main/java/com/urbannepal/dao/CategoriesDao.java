/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Categories;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myhp
 */
@Repository
public class CategoriesDao implements CategoriesDaoInterface{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCategory(Categories c) {
        Session sess = sessionFactory.openSession();
        sess.save(c);
        sess.close();
    }

    @Override
    public List<Categories> displayCategory() {
        Session sess = sessionFactory.openSession();
       // Query query = sessionFactory.getCurrentSession().createQuery("FROM Categories WHERE 1");
        
        List<Categories> c =sess.createCriteria(Categories.class).list();
        sess.close();
        return c;
    }

    @Override
    public boolean chaeckCategory(String catname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categories> displayCategoryName() {
        Session sess=sessionFactory.openSession();
        List<Categories> c=sess.createCriteria(Categories.class).list();
        sess.close();
        return c;
    }
    
}
