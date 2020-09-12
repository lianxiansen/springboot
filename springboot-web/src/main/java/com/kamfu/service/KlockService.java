package com.kamfu.service;

import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Service;

@Service
public class KlockService {
	public static int count=0;
    @Klock(waitTime = Long.MAX_VALUE)
    public synchronized void test() throws Exception {
    	for(int i=0;i<5;i++) {
        	System.out.println(Thread.currentThread().getName() + ":" + (count++));
    		Thread.sleep(5000);	
    	}

    }
}