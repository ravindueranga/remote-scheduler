// PROJECT : RemoteQuartzScheduler
// CLASS : JobDatas.java
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
// Date : May 19, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.rqs.model;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
public class EmailJobData {
  
  /*
   * Email Address of sender
   */
  String to;
  
  /*
   * Email Address of receiver
   */
  String from;
  
  /*
   * Host
   */
  String host;
  
  /*
   * Subject of the email
   */
  String subject;
  
  /*
   * Content of the email
   */
  String body;

  /**
   * @return the to
   */
  public String getTo() {
  
    return to;
  }

  /**
   * @param to the to to set
   */
  public void setTo(String to) {
  
    this.to = to;
  }

  /**
   * @return the from
   */
  public String getFrom() {
  
    return from;
  }

  /**
   * @param from the from to set
   */
  public void setFrom(String from) {
  
    this.from = from;
  }

  /**
   * @return the host
   */
  public String getHost() {
  
    return host;
  }

  /**
   * @param host the host to set
   */
  public void setHost(String host) {
  
    this.host = host;
  }

  /**
   * @return the subject
   */
  public String getSubject() {
  
    return subject;
  }

  /**
   * @param subject the subject to set
   */
  public void setSubject(String subject) {
  
    this.subject = subject;
  }

  /**
   * @return the body
   */
  public String getBody() {
  
    return body;
  }

  /**
   * @param body the body to set
   */
  public void setBody(String body) {
  
    this.body = body;
  }
  
  
  
}
