package com.rqs.quartz;

import java.io.Serializable;

public class RunMeTask implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1428227810923366371L;

	public void printMe() {
		System.out.println("Spring 3 + Quartz 1.8.6 ~");
	}
}