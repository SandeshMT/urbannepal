/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Email;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
public class EmailDao implements EmailDaoInterface{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmail(Email e) {
        Session sess=sessionFactory.openSession();
        sess.save(e);
        sess.close();
    }

    @Override
    public List<Email> displayEmail() {
        Session sess = sessionFactory.openSession();
        List<Email> result = sess.createCriteria(Email.class).list();
        sess.close();
        return result;
    }

    @Override
    public List<Email> displayEmailById(int eid) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Email.class);
        cr.add(Restrictions.eq("emailId", eid));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void updateEmailInformation(Email e) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Email e set e.subject=:subject, e.content=:content  where e.emailId=:emailId");
        query.setInteger("emailId", e.getEmailId());
        query.setString("subject", e.getSubject());
        query.setString("content", e.getContent());
        query.executeUpdate();
        sess.close();
    }

    @Override
    public void deleteEmail(int eid) {
        Session sess=sessionFactory.openSession();
        Query query=sessionFactory.getCurrentSession().createQuery("delete FROM Email e where e.emailId=:emailId");
        query.setInteger("emailId", eid);
        query.executeUpdate();
        sess.close();
    }

    @Override
    public List<Email> getEmailBySubject(String subject) {
     Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Email.class);
        cr.add(Restrictions.eq("subject", subject));
        List results = cr.list();
        sess.close();
        return results;   
    }

    @Override
    public void updateEmailImageOnly(int eid, String imgnm) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Email e set e.featuredImage=:featuredImage  where e.emailId=:emailId");
        query.setInteger("emailId", eid);
        query.setString("featuredImage", imgnm);
        query.executeUpdate();
        sess.close();
    }
    
}
