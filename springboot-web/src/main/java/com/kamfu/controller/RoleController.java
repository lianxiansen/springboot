package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.PagedList;
import com.kamfu.service.RoleService;

import lombok.extern.log4j.Log4j2;
@RequestMapping("/role")
@Controller
@Log4j2
public class RoleController extends AuthController{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
    @Autowired
    private RoleService roleService;


	@GetMapping("/selectPagedList")
    @ResponseBody
    public PagedList<Role> selectPagedList(int page,int pagesize){
    	return roleService.selectPagedList(page, pagesize);
    }

	

	

}
