/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author myhp
 */
public class ReceivingEmail2 {
    public void read() {
 
        Properties props = new Properties();
 
        try {
            props.load(new FileInputStream(new File("D:\\smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "nepbagz@gmail.com", "nepbagz2016");
 
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
 
            System.out.println("Total Messages:- " + messageCount);
 
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
 
            for (int i = 0; i < 10; i++) {
                System.out.println("Email Number:-"+i+1);
                System.out.println("Mail Subject:- " + messages[i].getSubject());
                System.out.println("Email From:-"+messages[i].getFrom()[0]);
                System.out.println("Email Content: "+messages[i].getContent());
            }
 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ReceivingEmail2 gmail = new ReceivingEmail2();
        gmail.read();
    }
}
