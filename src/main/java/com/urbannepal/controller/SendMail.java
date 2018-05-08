/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urbannepal.controller;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author myhp
 */
public class SendMail {

    public static void main(String[] args) {
        String to = "suman.thapa1605@gmail.com  ";//change accordingly  
        final String username = "nepbagz@gmail.com";//change accordingly  
        final String password = "nepbagz2016";//change accordingly  
        final String link="www.facebook.com";

        //getting properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //getting session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {
            //compose message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            message.setSubject("HTML Message with attachment");

            //creating MimeBodyPart object and setting text message    
            BodyPart htmlcont = new MimeBodyPart();
            htmlcont.setText("This is message contains both html and attachment");
            htmlcont.setContent("<h1>This is heading 1</h1><p>this is paragraph</p><a href="+link+">click here to login into facebook</a>","text/html");

            //creating new MimeBodyPart object and setting DataHandler object to this object      
            MimeBodyPart attachment = new MimeBodyPart();

            String filename = "C:/Users/myhp/Desktop/print.docx";//change accordingly  
            DataSource source = new FileDataSource(filename);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(filename);

            //creating Multipart object and adding MimeBodyPart objects to this object      
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlcont);
            multipart.addBodyPart(attachment);

            // setting the multiplart object to the message object  
            message.setContent(multipart);
        //message.setContent("<h1>sending html mail check</h1>","text/html" );  

            //sending message
            Transport.send(message);
            System.out.println("message sent....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
