/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.entity.Contacts;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface ContactServiceInterface {
    public int addAndGetNewId(Contacts c);
    
    public void addContact(Contacts c);

    public List<Contacts> displayContacts();
    
    public List<Contacts> displayContactsById(int srchvalue);
    
    public List<Contacts> displayContactsByInitialWord(String srchvalue);
    
    public void deleteContact(int cid);
    
    public void updateContact(Contacts c);
    
    public void updateProfilePic(int contID, String imgnum);
}
