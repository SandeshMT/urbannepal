/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Contacts;
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
public class ContactDao implements ContactDaoInterface {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void deleteContact(int cid) {
        Session sess=sessionFactory.openSession();
        Transaction t=sess.beginTransaction();
        Contacts p= (Contacts) sess.load(Contacts.class, cid);
        sess.delete(p);
        t.commit();
        sess.close();
    }

    @Override
    public void updateContact(Contacts c) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Contacts c set c.firstname=:firstname,c.lastnanme=:lastnanme,c.primaryno=:primaryno,c.secondaryno=:secondaryno,c.primaryaddress=:primaryaddress,c.secondaryaddress=:secondaryaddress,c.gender=:gender,c.email=:email,c.profession=:profession  where c.contactId=:contactId");
        query.setInteger("contactId", c.getContactId());
        query.setString("firstname", c.getFirstname());
        query.setString("lastnanme", c.getLastnanme());
        query.setString("primaryno", c.getPrimaryno());
        query.setString("secondaryno", c.getSecondaryno());
        query.setString("primaryaddress", c.getPrimaryaddress());
        query.setString("secondaryaddress", c.getSecondaryaddress());
        query.setString("gender", c.getGender());
        query.setString("email", c.getEmail());
        query.setString("profession", c.getProfession());
        query.executeUpdate();
        sess.close();
    }

    @Override
    public void addContact(Contacts c) {
        Session sess = sessionFactory.openSession();
        sess.save(c);
        sess.persist(c);
    }

    @Override
    public List<Contacts> displayContacts() {
        Session sess = sessionFactory.openSession();
        List<Contacts> c = sess.createCriteria(Contacts.class).list();
        sess.close();
        return c;
    }

    @Override
    public List<Contacts> displayContactsByInitialWord(String srchvalue) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Contacts.class);
        cr.add(Restrictions.like("firstname", srchvalue + "%"));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public int addAndGetNewId(Contacts c) {
        Session sess = sessionFactory.openSession();
        sess.save(c);
        sess.persist(c);
        int a=c.getContactId();
        sess.close();
        return a;
    }

    @Override
    public List<Contacts> displayContactsById(int srchvalue) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(Contacts.class);
        cr.add(Restrictions.eq("contactId", srchvalue));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void updateProfilePic(int contID, String imgnum) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update Contacts c set c.profilepicture=:profilepicture  where c.contactId=:contactId");
        query.setInteger("contactId", contID);
        query.setString("profilepicture", imgnum);
        query.executeUpdate();
        sess.close();
    }

}
