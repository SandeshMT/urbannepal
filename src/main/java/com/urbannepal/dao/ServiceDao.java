/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Categories;
import com.urbannepal.entity.Servicelist;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myhp
 */
@Repository
public class ServiceDao implements ServiceDaoInterface{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addService(Servicelist s) {
        Session sess=sessionFactory.openSession();
        sess.save(s);
        sess.close();
    }

    @Override
    public List<Servicelist> displayService() {
        Session sess = sessionFactory.openSession();
        List<Servicelist> results =sess.createCriteria(Servicelist.class).list();
        sess.close();
        return results;
    }

    @Override
    public List<Servicelist> displayServiceById(int sid) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Servicelist.class);
        cr.add(Restrictions.eq("slId", sid));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void updateServiceInformation(Servicelist s) {
        Session sess = sessionFactory.openSession();
        Transaction tx = sess.beginTransaction();
        sess.update(s);
        tx.commit();
        sess.close();
    }

    @Override
    public void deleteService(int sid) {
        Session sess=sessionFactory.openSession();
        Transaction t=sess.beginTransaction();
        Servicelist s= (Servicelist) sess.load(Servicelist.class, sid);
        sess.delete(s);
        t.commit();
        sess.close();
    }

    @Override
    public List<Servicelist> displayServiceName() {
        Session sess = sessionFactory.openSession();
        List<Servicelist> results = sess.createCriteria(Servicelist.class).list();
        sess.close();
        return results;
    }
    
}
