package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.model.PermissionInfo;
import com.kamfu.service.PermissionService;

import lombok.extern.log4j.Log4j2;
@RequestMapping("/permission")
@Controller
@Log4j2
public class PermissionController extends AuthController{
	@Autowired
	private PermissionMapper permissionMapper;
    @Autowired
    private PermissionService permissionService;


	@GetMapping("/selectList")
    @ResponseBody
    public List<Permission> selectList(){
    	return permissionService.selectList();
    }
	@GetMapping("/selectListByRoleId")
    @ResponseBody
	public List<Permission> selectListByRoleId(Long roleId){
		return permissionMapper.selectListByRoleId(roleId);
	}
	@GetMapping("/selectAllListByRoleId")
    @ResponseBody
	public List<PermissionInfo> selectAllListByRoleId(Long roleId){
		return permissionService.selectAllListByRoleId(roleId);
	}

}
