package com.kamfu.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.model.LayuiTreeNode;
@Component
public class WebApiServiceHystrix implements WebApiService {

	@Override
	public List<LayuiTreeNode> layuiTree(Long deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUser(String username) {
		// TODO Auto-generated method stub
		return "服务降级【user:】"+username;
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserPagedList(Long deptId, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> selectPermissionList(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
