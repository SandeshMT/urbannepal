/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.ServiceDao;
import com.urbannepal.entity.Servicelist;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author myhp
 */
@Service
public class ServiceService implements ServiceServiceInterface{
    @Autowired
    ServiceDao srvDao;

    public ServiceDao getSrvDao() {
        return srvDao;
    }

    public void setSrvDao(ServiceDao srvDao) {
        this.srvDao = srvDao;
    }

    @Transactional
    @Override
    public void addService(Servicelist s) {
        srvDao.addService(s);
    }

    @Transactional
    @Override
    public List<Servicelist> displayService() {
        return srvDao.displayService();
    }

    @Transactional
    @Override
    public List<Servicelist> displayServiceById(int sid) {
       return srvDao.displayServiceById(sid);
    }

    @Transactional
    @Override
    public void updateServiceInformation(Servicelist s) {
        srvDao.updateServiceInformation(s);
    }

    @Transactional
    @Override
    public void deleteService(int sid) {
        srvDao.deleteService(sid);
    }

    @Transactional
    @Override
    public List<Servicelist> displayServiceName() {
        return srvDao.displayServiceName();
    }
    
}
