package com.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution je) {
		// TODO Auto-generated method stub
		
		System.out.println("started date and time :"+new Date());
		System.out.println("Job Status :"+je.getStatus());
	}

	@Override
	public void afterJob(JobExecution je) {
		// TODO Auto-generated method stub
		System.out.println("ended date and time :"+new Date());
		System.out.println("Job Status :"+je.getStatus());
	
		
	}

}
