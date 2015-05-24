// PROJECT : RemoteQuartzScheduler
// CLASS : JobB.java
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
// Date : May 24, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.rqs.quartz;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

import com.rqs.model.CustomUrlData;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
public class JobB implements Job {
  
  /*
   * (non-Javadoc)
   * 
   * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
   */
  public void execute(JobExecutionContext context) throws JobExecutionException {
  
    
    System.out.println("Job B is runing");
    
    
    SchedulerContext schedulerContext = null;
    
    try {
      schedulerContext = context.getScheduler().getContext();
    } catch (SchedulerException e) {
      
      e.printStackTrace();
    }
    
    
    CustomUrlData customUrlData = (CustomUrlData) schedulerContext.get("externalInstance");
    
    String url = customUrlData.getUrl();
    
    URL obj;
    HttpURLConnection con = null;
    try {
      obj = new URL(url);
      
      con = (HttpURLConnection) obj.openConnection();
      
      // optional default is GET
      con.setRequestMethod("GET");
    } catch (MalformedURLException e) {
      
      e.printStackTrace();
    } catch (ProtocolException e) {
      
      e.printStackTrace();
    } catch (IOException e) {
      
      e.printStackTrace();
    }
    
    
    // add request header
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    
    try {
      int responseCode = con.getResponseCode();
    } catch (IOException e) {
      
      e.printStackTrace();
    }
    
  }
  
}
