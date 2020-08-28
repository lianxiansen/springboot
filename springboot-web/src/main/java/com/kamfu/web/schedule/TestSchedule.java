package com.kamfu.web.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {
	   @Scheduled(cron = "0 0/1 * * * ?")
	    public void scheduled() {
	        try {
	        	  SimpleDateFormat ft = 
	        		      new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	        	System.out.println("定时任务running……"+ft.format(new Date()));
	        } catch (Exception e) {
	           
	        }
	    }
}
