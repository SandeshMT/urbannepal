/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.dao;

import com.urbannepal.entity.Email;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface EmailDaoInterface {
    public void addEmail(Email e);
    
    public List<Email> displayEmail();
    
    public List<Email> displayEmailById(int eid);
    
    public List<Email> getEmailBySubject(String subject);
    
    public void updateEmailInformation(Email e);
    
    public void deleteEmail(int eid);
    
    public void updateEmailImageOnly(int eid, String imgnm);
}
