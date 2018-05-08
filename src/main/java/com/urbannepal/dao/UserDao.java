/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Subscribers;
import com.urbannepal.entity.User;
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
public class UserDao implements UserDaoInterface{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    public void addUsers(User u) {
        Session sess = sessionFactory.openSession();
        sess.save(u);
        sess.close();
    }

    @Override
    public List<User> displayUsers() {
        Session sess = sessionFactory.openSession();
        List<User> usr = sess.createCriteria(User.class).list();
        sess.close();
        return usr;
    }

    @Override
    public void updateUserInformation(User u) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update User u set u.username=:username,u.firstname=:firstname,u.lastname=:lastname,u.email=:email,u.biographicalInformation=:biographicalInformation,u.role=:role,u.contactId=:contactId where u.userId=:userId");
        query.setInteger("userId", u.getUserId());
        query.setString("username", u.getUsername());
        query.setString("firstname", u.getFirstname());
        query.setString("lastname", u.getLastname());
        query.setString("email", u.getEmail());
        query.setString("biographicalInformation", u.getBiographicalInformation());
        query.setString("role", u.getRole());
        query.setInteger("contactId", u.getContactId());
        query.executeUpdate();
        System.out.println("User ID="+u.getUserId());
        System.out.println("Username="+u.getUsername());
        System.out.println("First Name="+u.getFirstname());
        System.out.println("Last Name="+u.getLastname());
        System.out.println("Email="+u.getEmail());
        System.out.println("Biography="+u.getBiographicalInformation());
        System.out.println("Role="+u.getRole());
        System.out.println("Contact ID="+u.getContactId());
        sess.close();
    }

    @Override
    public void deleteUser(int uid) {
        Session sess=sessionFactory.openSession();
        Transaction t=sess.beginTransaction();
        User u= (User) sess.load(User.class, uid);
        sess.delete(u);
        t.commit();
        sess.close();
    }

    @Override
    public List<User> displayUserById(int uid) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(User.class);
        cr.add(Restrictions.eq("userId", uid));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public List<User> displayUserByRole(int role) {
        Session sess = sessionFactory.openSession();
        Criteria cr = sess.createCriteria(User.class);
        cr.add(Restrictions.eq("role", role));
        List results = cr.list();
        sess.close();
        return results;
    }

    @Override
    public void newSubscriber(Subscribers subs) {
        Session sess = sessionFactory.openSession();
        sess.save(subs);
        sess.close();
    }

    @Override
    public List<Subscribers> displaySubscribers() {
        Session sess = sessionFactory.openSession();
        List<Subscribers> results = sess.createCriteria(Subscribers.class).list();
        sess.close();
        return results;
    }

    @Override
    public void updateUsrProfilePic(int userID, String imgnum) {
        Session sess=sessionFactory.openSession();
        Query query=sess.createQuery("update User u set u.profilepicture=:profilepicture  where u.userId=:userId");
        query.setInteger("userId", userID);
        query.setString("profilepicture", imgnum);
        query.executeUpdate();
        System.out.println("yeha samma aayo");
        sess.close();
    }
    
}
