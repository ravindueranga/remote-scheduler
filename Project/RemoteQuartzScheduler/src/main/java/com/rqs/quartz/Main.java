package com.rqs.quartz;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Time t = ConvertToTime("12:00", "AM");
		System.out.println( t.toString());
		System.out.println(convert12HourClockString(t));
	}
	 private static Time ConvertToTime(String time, String abbrvtion) {
		  
		    java.util.Date d1 = new Date();
		    try {
		      
		      SimpleDateFormat format = new SimpleDateFormat("hh:mm a"); // if 24 hour format
		      d1 = (java.util.Date) format.parse(time + " " + abbrvtion);
		      
		    } catch (Exception e) {
		      
		      System.out.println("Exception is " + e.toString());
		    }
		    return new java.sql.Time(d1.getTime());
		  }
	 
	 public static String convert12HourClockString(Time time) {
		 
		 SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		 Date date = new Date(time.getTime());
		 return format.format(date);
	 }
}
