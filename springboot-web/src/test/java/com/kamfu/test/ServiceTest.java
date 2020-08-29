package com.kamfu.test;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamfu.Application;
import com.kamfu.entity.User;
import com.kamfu.service.DeptService;
import com.kamfu.service.UserService;


/**
 * 测试任务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;
	@Resource
	private DeptService deptService;
	@Resource
	private UserService userService;
	
//	@Autowired
//
//	private  RedisTemplate<String,  String>  redisTemplate;
	@Test
	public void test() {
		List<User> list=userService.selectPagedList(24L, 1, 20);

		System.out.println("");
	}
}
