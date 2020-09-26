package com.kamfu.service;

import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Service;

import com.kamfu.entity.User;

@Service
public class KlockService {
	public static int count=100;
    @Klock(keys = { "#user.id"})
    public  void test(User user) throws Exception {
    	for(int i=0;i<5;i++) {
        	System.out.println(Thread.currentThread().getName()+"用户id:"+user.getId() + "-------" + (count--));
    		Thread.sleep(1000);	
    	}

    }
}