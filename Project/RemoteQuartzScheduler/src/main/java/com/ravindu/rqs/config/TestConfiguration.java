// PROJECT : RemoteQuartzScheduler
// CLASS : TestConfiguration.java
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
// Date : Feb 28, 2015
// Version : version 1.0
//
// *************************************************************************************************

package com.ravindu.rqs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ravindu.rqs.service.TestService;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Configuration
@ComponentScan
public class TestConfiguration {
  
  @Bean
  public TestService getService() {
  
    return new TestService();
  }
}
