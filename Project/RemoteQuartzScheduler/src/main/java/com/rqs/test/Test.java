// PROJECT : RemoteQuartzScheduler
// CLASS : Test.java
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
// Date : Feb 13, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.rqs.test;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rqs.config.TestConfiguration;
import com.rqs.model.CustomUrlData;
import com.rqs.model.EmailJobData;
import com.rqs.model.Stock;
import com.rqs.quartz.JobA;
import com.rqs.quartz.JobB;
import com.rqs.service.StockService;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Path("/scheduler")
public class Test implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = -262701666015379272L;
  
  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfiguration.class);
  
  @GET
  @Path("/hello")
  public Response heloMessage() {
  
    
//    TestService service = ctx.getBean(TestService.class);
    
    String output = "Hello Word  !!!!!!!!!";
    
    EmailJobData product = new EmailJobData();
    product.setBody("iPad 3");
    product.setHost("sefsef");;

    return Response.ok(product, MediaType.APPLICATION_JSON).build();
    
//    return Response.status(200).entity(output).build();
  }
  
  
  @GET
  @Path("/get")
  @Produces("application/json")
  public EmailJobData getProductInJSON(){

    EmailJobData product = new EmailJobData();
      product.setBody("iPad 3");
      product.setHost("sefsef");
      
      String url = "http://localhost:8080/RESTfulExample/message/get";
      
      URL obj;
      try {
        obj = new URL(url);
        
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
      } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    

      return product; 

  }
  
  
  @POST
  @Path("/EmailPost")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response emailPost(EmailJobData emailJobData) {

      String result = "Product created : " + emailJobData;
      
      JobKey jobKeyA = new JobKey("jobA", "group1");
      JobDetail jobA = JobBuilder.newJob(JobA.class)
      .withIdentity(jobKeyA).build();

      Trigger trigger1 = TriggerBuilder
          .newTrigger()
          .withIdentity("dummyTriggerName1", "group1")
          .withSchedule(
              CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
          .build();
   
      Scheduler scheduler;
      
      try {
        
        scheduler = new StdSchedulerFactory().getScheduler();
        
//        EmailJobData emailJobData = new EmailJobData();
//        
//        emailJobData.setFrom("ravindueranga@gmail.com");
//        emailJobData.setTo("ravindueranga33@gmail.com");
//        emailJobData.setHost("localhost");
//        emailJobData.setSubject("Test Subject");
//        emailJobData.setBody("This is the test body of the email message.");
        
        scheduler.getContext().put("externalInstance", emailJobData);
        
        
        scheduler.start();
        scheduler.scheduleJob(jobA, trigger1);
        
      } catch (SchedulerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
            
      return Response.status(201).entity(result).build();

  }
  
  
  @POST
  @Path("/UrlPost")
  @Consumes("application/json")
  public Response urlPost(CustomUrlData customUrlData) {

       
      JobKey jobKeyB = new JobKey("jobB", "group2");
      JobDetail jobB = JobBuilder.newJob(JobB.class)
      .withIdentity(jobKeyB).build();

      Trigger trigger1 = TriggerBuilder
          .newTrigger()
          .withIdentity("dummyTriggerName2", "group2")
          .withSchedule(
              CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
          .build();
   
      Scheduler scheduler;
      
      try {
        
        scheduler = new StdSchedulerFactory().getScheduler();
        
//        EmailJobData emailJobData = new EmailJobData();
//        
//        emailJobData.setFrom("ravindueranga@gmail.com");
//        emailJobData.setTo("ravindueranga33@gmail.com");
//        emailJobData.setHost("localhost");
//        emailJobData.setSubject("Test Subject");
//        emailJobData.setBody("This is the test body of the email message.");
        
        scheduler.getContext().put("externalInstance", customUrlData);
        
        
        scheduler.start();
        scheduler.scheduleJob(jobB, trigger1);
        
      } catch (SchedulerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
            
      return Response.status(201).build();

  }
  
  
  
  @GET
  @Path("/hibernate")
  public Response hibernateTest() {
  
    
    StockService service = (StockService) ctx.getBean("stockService");
    
    Stock s = new Stock();
    s.setStockCode("S001");
    s.setStockName("Test Stock");    
    
    service.save(s);
    
    return Response.status(200).build();
  }
  
}
