package com.kamfu.test;

import org.springframework.boot.autoconfigure.klock.annotation.Klock;

import com.kamfu.service.KlockService;

public class SyncThread implements Runnable{
	private KlockService klockService;
	
	 public KlockService getKlockService() {
		return klockService;
	}

	public void setKlockService(KlockService klockService) {
		this.klockService = klockService;
	}

	public void run() {
		try {
			klockService.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}
}
