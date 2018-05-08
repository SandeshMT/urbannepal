/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.entity.Servicelist;
import java.util.List;

/**
 *
 * @author myhp
 */
public interface ServiceServiceInterface {
    public void addService(Servicelist s);
    
    public List<Servicelist> displayService();
    
    public List<Servicelist> displayServiceById(int sid);
    
    public void updateServiceInformation(Servicelist s);
    
    public void deleteService(int sid);
    
    public List<Servicelist> displayServiceName();
}
