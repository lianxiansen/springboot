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
import org.springframework.test.context.junit4.SpringRunner;

import com.kamfu.Application;
import com.kamfu.model.LayuiTreeNode;
import com.kamfu.mybatis.mapper.PermissionMapper;
import com.kamfu.mybatis.mapper.RoleMapper;
import com.kamfu.service.DeptService;
import com.kamfu.service.UserService;
import com.kamfu.util.Md5Util;



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
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Test
	public void deptService() {
//		Role roleEntity=roleMapper.selectById(28);
		List<LayuiTreeNode> list = deptService.layuiTree(24L);
//		Permission role=new Permission();
//		role.setName("系统管理");
//		role.setCreateTime(new Date());
//		role.setSort(1);
//		role.setPid(0L);
//		role.setPids("0");
//		int i=permissionMapper.insert(role);
		
		System.out.println(list);
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
