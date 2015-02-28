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

package com.ravindu.rqs.test;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ravindu.rqs.config.TestConfiguration;
import com.ravindu.rqs.service.TestService;

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
  
  @GET
  @Path("/hello")
  public Response heloMessage() {
  
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfiguration.class);
    TestService service = ctx.getBean(TestService.class);
    
    String output = service.print("Hello Word!!!!!!!!!");
    
    return Response.status(200).entity(output).build();
  }
  
  
}
