package com.rqs.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.rqs.model.EmailJobData;

public class App {
  
  
  
  public static void main(String[] args) throws Exception {
  
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Quartz.xml");
//    
//    SchedulerFactoryBean schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
//    Scheduler scheduler = schedulerFactoryBean.getScheduler();
//    
//    
//    
//    Connection conn = DBConnectionManager.getInstance().getConnection("myDS");
//    
//    System.out.println(scheduler.isStarted());
//    System.out.println(scheduler.isShutdown());
    
    
    JobKey jobKeyA = new JobKey("jobA", "group1");
    JobDetail jobA = JobBuilder.newJob(JobA.class)
    .withIdentity(jobKeyA).build();
    
 // jobA.getJobDataMap().put(key, value);

    Trigger trigger1 = TriggerBuilder
        .newTrigger()
        .withIdentity("dummyTriggerName1", "group1")
        .withSchedule(
            CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
        .build();
 
    Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    
    
    EmailJobData emailJobData = new EmailJobData();
    
    emailJobData.setFrom("ravindueranga@gmail.com");
    emailJobData.setTo("ravindueranga33@gmail.com");
    emailJobData.setHost("localhost");
    emailJobData.setSubject("Test Subject");
    emailJobData.setBody("This is the test body of the email message.");
    
    scheduler.getContext().put("externalInstance", emailJobData);
    
    
    scheduler.start();
    scheduler.scheduleJob(jobA, trigger1);
    
    // for (;;) {
    //
    // System.out.println(scheduler.isStarted());
    // System.out.println(scheduler.isShutdown());
    // Thread.sleep(1000);
    // }
    
  }
}
