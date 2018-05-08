/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.service;

import com.urbannepal.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author myhp
 */
@Service
public class LoginService implements LoginServiceInterface{
    @Autowired
    LoginDao logindao;

    public LoginDao getLogindao() {
        return logindao;
    }

    public void setLogindao(LoginDao logindao) {
        this.logindao = logindao;
    }
    
}
