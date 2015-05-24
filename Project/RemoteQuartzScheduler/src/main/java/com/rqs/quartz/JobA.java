// PROJECT : RemoteQuartzScheduler
// CLASS : JobA.java
//
// ************************************************************************************************
//
// This copy of the Source Code is a property of Ravindu Eranga Abayawardena. No
// part of this file may be reproduced or distributed in any form or by any
// means without the written approval of Ravindu Eranga Abayawardena.
//
// *************************************************************************************************
//
// REVISIONS:
// Author : Ravindu Eranga Abayawardena
// Date : Apr 16, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.rqs.quartz;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

import com.rqs.model.EmailJobData;

/**
 * Send an email to selected sender
 * 
 * @author Ravindu Eranga Abaywardena
 */
public class JobA implements Job {
  
  /*
   * (non-Javadoc)
   * 
   * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
   */
  public void execute(JobExecutionContext context) throws JobExecutionException {
  
    System.out.println("Job A is runing");
    
    
    SchedulerContext schedulerContext = null;
    
    try {
      schedulerContext = context.getScheduler().getContext();
    } catch (SchedulerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    EmailJobData emailJobData = (EmailJobData) schedulerContext.get("externalInstance");
    
    
    
    Properties props = System.getProperties();
    String host = "smtp.gmail.com";
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    // props.put("mail.smtp.user", "ravindueranga");
    // props.put("mail.smtp.password", "nsbpyhtjxncmwzvu");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    
    
    
    // Session session = Session.getDefaultInstance(props);
    
    Session session = Session.getInstance(props, new GMailAuthenticator("ravindueranga", "nsbpyhtjxncmwzvu"));
    
    MimeMessage message = new MimeMessage(session);
    //
    // Transport transport = session.getTransport("smtp");
    // transport.connect(host, from, pass);
    // transport.sendMessage(message, message.getAllRecipients());
    // transport.close();
    //
    
    try {
//      message.setFrom(new InternetAddress(emailJobData.getFrom()));
      
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailJobData.getTo()));
      
      message.setSubject(emailJobData.getSubject());
      
      message.setText(emailJobData.getBody());
      
      Transport.send(message);
      
      System.out.println("Sent message successfully....");
      
    } catch (MessagingException e) {
      
      e.printStackTrace();
    }
    
    
    
  }
  
}
