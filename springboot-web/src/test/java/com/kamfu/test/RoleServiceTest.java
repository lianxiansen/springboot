package com.kamfu.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamfu.WebApiApplication;
import com.kamfu.entity.Role;
import com.kamfu.mapper.DeptMapper;
import com.kamfu.model.PagedList;
import com.kamfu.service.RoleService;



/**
 * 测试任务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RoleService roleService;
	@Test
	public void test() {
	    PagedList<Role> roleList= roleService.selectPagedList(1, 10);
	    System.out.println("end");
	}

}
