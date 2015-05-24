//PROJECT    : RemoteQuartzScheduler 
//CLASS      : CustomUrlData.java
//
//************************************************************************************************
//
// This copy of the Source Code is a property of Ravindu Eranga Abayawardena. No 
// part of this file may be reproduced or distributed in any form or by any
// means without the written approval of Ravindu Eranga Abayawardena. 
// 
//*************************************************************************************************
// 
// REVISIONS: 
//    Author          : Ravindu Eranga Abayawardena   
//    Date            : May 24, 2015      
//    Version          : version 1.0
//
//*************************************************************************************************

package com.rqs.model;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
public class CustomUrlData {
  
  String url;
  
  Boolean needAuthontication;

  /**
   * @return the url
   */
  public String getUrl() {
  
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
  
    this.url = url;
  }

  /**
   * @return the needAuthontication
   */
  public Boolean getNeedAuthontication() {
  
    return needAuthontication;
  }

  /**
   * @param needAuthontication the needAuthontication to set
   */
  public void setNeedAuthontication(Boolean needAuthontication) {
  
    this.needAuthontication = needAuthontication;
  }

  
}
