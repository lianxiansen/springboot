package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.service.UserService;

import lombok.extern.log4j.Log4j2;
@RequestMapping("/user")
@Controller
@Log4j2
public class UserController extends AuthController{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
    @Autowired
    private UserService userService;
	@GetMapping("/getRoleById")
    @ResponseBody
    public Role getRoleById(Long id){
    	return roleMapper.selectById(id);
    }
	
	@GetMapping("/getUserByUsername")
    @ResponseBody
    public User getUserByUsername(String username){
    	return userService.getByUsername(username);
    }

	@GetMapping("/selectPagedList")
    @ResponseBody
    public List<User> selectPagedList(Long deptId,int page,int pagesize){
    	return userService.selectPagedList(deptId, page, pagesize);
    }

	@GetMapping("/selectPermissionList")
    @ResponseBody
	public List<Permission> selectPermissionList(Long roleId){
		return permissionMapper.selectListByRoleId(roleId);
	}
}
