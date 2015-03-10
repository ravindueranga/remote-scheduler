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

package com.rqs.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rqs.test.TestService;

/**
 * 
 * @author Ravindu Eranga Abaywardena
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.ravindu.rqs")
@PropertySource(value = {"classpath:application.properties"})
public class TestConfiguration {
  
  @Autowired
  private Environment environment;
  
  @Bean
  public TestService getService() {
  
    return new TestService();
  }
  
  @Bean
  public DriverManagerDataSource dataSource() {
  
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
    driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
    driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
    driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
    
    return driverManagerDataSource;
    
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
  
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[] {"com.ravindu.rqs.model"});
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
    
  }
  
  private Properties hibernateProperties() {
  
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    return properties;
  }
  
  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory s) {
  
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(s);
    return txManager;
  }
  
}
