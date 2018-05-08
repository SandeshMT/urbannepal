/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.ContactDao;
import com.urbannepal.entity.Contacts;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class ContactService implements ContactServiceInterface{
    @Autowired
    ContactDao contdao;

    public ContactDao getContdao() {
        return contdao;
    }

    public void setContdao(ContactDao contdao) {
        this.contdao = contdao;
    }
    
    
    @Transactional
    @Override
    public void deleteContact(int cid) {
        contdao.deleteContact(cid);
    }

    @Transactional
    @Override
    public void updateContact(Contacts c) {
        contdao.updateContact(c);
    }

    @Transactional
    @Override
    public void addContact(Contacts c) {
        contdao.addContact(c);
    }

    @Transactional
    @Override
    public List<Contacts> displayContacts() {
        return contdao.displayContacts();
    }

    @Transactional
    @Override
    public List<Contacts> displayContactsByInitialWord(String srchvalue) {
        return contdao.displayContactsByInitialWord(srchvalue);
    }

    @Transactional
    @Override
    public int addAndGetNewId(Contacts c) {
        return contdao.addAndGetNewId(c);
    }

    @Transactional
    @Override
    public List<Contacts> displayContactsById(int srchvalue) {
        return contdao.displayContactsById(srchvalue);
    }

    @Transactional
    @Override
    public void updateProfilePic(int contID, String imgnum) {
        contdao.updateProfilePic(contID, imgnum);
    }
    
}
