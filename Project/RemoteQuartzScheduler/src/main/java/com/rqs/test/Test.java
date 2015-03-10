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

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rqs.config.TestConfiguration;
import com.rqs.model.Stock;
import com.rqs.service.StockService;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Path("/TestClass")
public class Test implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = -262701666015379272L;
  
  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfiguration.class);
  
  @GET
  @Path("/hello")
  public Response heloMessage() {
  
    
    TestService service = ctx.getBean(TestService.class);
    
    String output = service.print("Hello Word!!!!!!!!!");
    
    return Response.status(200).entity(output).build();
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
