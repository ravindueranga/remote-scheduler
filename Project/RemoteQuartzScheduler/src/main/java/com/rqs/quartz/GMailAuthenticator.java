// PROJECT : RemoteQuartzScheduler
// CLASS : GMailAuthenticator.java
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

package com.rqs.quartz;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
public class GMailAuthenticator extends Authenticator {
  
  String user;
  
  String pw;
  
  public GMailAuthenticator(String username, String password) {
  
    super();
    this.user = username;
    this.pw = password;
  }
  
  public PasswordAuthentication getPasswordAuthentication() {
  
    return new PasswordAuthentication(user, pw);
  }
  
}
