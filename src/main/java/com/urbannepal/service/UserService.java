/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.UserDao;
import com.urbannepal.entity.Subscribers;
import com.urbannepal.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class UserService implements UserServiceInterface{
    @Autowired
    UserDao udao;

    public UserDao getUdao() {
        return udao;
    }

    public void setUdao(UserDao udao) {
        this.udao = udao;
    }
    

    @Transactional
    @Override
    public void addUsers(User u) {
        udao.addUsers(u);
    }

    @Transactional
    @Override
    public List<User> displayUsers() {
        return udao.displayUsers();
    }

    @Transactional
    @Override
    public void updateUserInformation(User u) {
        udao.updateUserInformation(u);
    }

    @Transactional
    @Override
    public void deleteUser(int uid) {
        udao.deleteUser(uid);
    }

    @Transactional
    @Override
    public List<User> displayUserById(int uid) {
        return udao.displayUserById(uid);
    }

    @Transactional
    @Override
    public List<User> displayUserByRole(int role) {
        return udao.displayUserByRole(role);
    }

    @Transactional
    @Override
    public void newSubscriber(Subscribers subs) {
        udao.newSubscriber(subs);
    }

    @Transactional
    @Override
    public List<Subscribers> displaySubscribers() {
        return udao.displaySubscribers();
    }

    @Transactional
    @Override
    public void updateUsrProfilePic(int userID, String imgnum) {
        udao.updateUsrProfilePic(userID, imgnum);
    }
    
}
