package com.kamfu.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamfu.WebApiApplication;
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
			SyncThread syncThread1 = new SyncThread();
			syncThread1.setKlockService(klockService);
			
			SyncThread syncThread2 = new SyncThread();
			syncThread2.setKlockService(klockService);
			Thread thread1 = new Thread(syncThread1, "SyncThread1");
			Thread thread2 = new Thread(syncThread2, "SyncThread2");
			thread1.start();
			thread2.start();
			Thread.sleep(10000000);
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
