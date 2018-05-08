/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.EmailDao;
import com.urbannepal.entity.Email;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class EmailService implements EmailServiceInterface{
    @Autowired
    EmailDao emailDao;

    public EmailDao getEmailDao() {
        return emailDao;
    }

    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    @Transactional
    @Override
    public void addEmail(Email e) {
        emailDao.addEmail(e);
    }

    @Transactional
    @Override
    public List<Email> displayEmail() {
        return emailDao.displayEmail();
    }

    @Transactional
    @Override
    public List<Email> displayEmailById(int eid) {
        return emailDao.displayEmailById(eid);
    }

    @Transactional
    @Override
    public void updateEmailInformation(Email e) {
        emailDao.updateEmailInformation(e);
    }

    @Transactional
    @Override
    public void deleteEmail(int eid) {
        emailDao.deleteEmail(eid);
    }

    @Transactional
    @Override
    public List<Email> getEmailBySubject(String subject) {
        return emailDao.getEmailBySubject(subject);
    }

    @Transactional
    @Override
    public void updateEmailImageOnly(int eid, String imgnm) {
        emailDao.updateEmailImageOnly(eid, imgnm);
    }
    
}
