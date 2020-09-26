package com.kamfu.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamfu.WebApiApplication;
import com.kamfu.entity.User;
import com.kamfu.service.KlockService;
import com.kamfu.util.Md5Util;



/**
 * 测试任务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	@Autowired
	private KlockService klockService;
	
	
	@Test
	public void test() {
		try {
			User user1=new User();user1.setId(1L);
			User user2=new User();user2.setId(1L);
			User user3=new User();user3.setId(2L);
			SyncThread syncThread1 = new SyncThread();
			syncThread1.setKlockService(klockService,user1);
			
			SyncThread syncThread2 = new SyncThread();
			syncThread2.setKlockService(klockService,user2);
			
			SyncThread syncThread3 = new SyncThread();
			syncThread3.setKlockService(klockService,user3);
			Thread thread1 = new Thread(syncThread1, "SyncThread1");
			Thread thread2 = new Thread(syncThread2, "SyncThread2");
			Thread thread3 = new Thread(syncThread3, "SyncThread3");
			thread1.start();
			thread2.start();
			thread3.start();
			Thread.sleep(1000000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void md5() {
		
		String originalPassword = "123456"; //原始密码
        String hashAlgorithmName = "MD5"; //加密方式
        int hashIterations = 2; //加密的次数
 
        //盐
        String salt = Md5Util.getRandomSalt();
 
        //加密
//        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, originalPassword, salt, hashIterations);
//        String encryptionPassword = simpleHash.toString();
        String encryptionPassword=Md5Util.encrypt(originalPassword, salt);
//		User user=userService.getByUsername("admin");
		System.out.println(encryptionPassword);
	}
}
