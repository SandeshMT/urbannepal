/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Subscribers;
import com.urbannepal.entity.User;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface UserDaoInterface {
    public void addUsers(User u);
    
    public List<User> displayUsers();
    
    public List<User> displayUserById(int uid);
    
    public List<User> displayUserByRole(int role);
    
    public void updateUserInformation(User u);
    
    public void deleteUser(int uid);
    
    public void newSubscriber(Subscribers subs);
    
    public List<Subscribers> displaySubscribers();
    
    public void updateUsrProfilePic(int userID, String imgnum);
}
