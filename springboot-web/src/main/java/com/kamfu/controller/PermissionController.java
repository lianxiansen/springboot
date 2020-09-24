package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.entity.User;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.model.BaseResponse;
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
	@GetMapping("/selectTreeListByRoleId")
    @ResponseBody
	public List<PermissionInfo> selectTreeListByRoleId(Long roleIdChoose,Long roleIdMe){
		return permissionService.selectTreeListByRoleId(roleIdChoose,roleIdMe);
	}

	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(@RequestBody Permission permission) {
		try {
			permissionService.add(permission);
			return BaseResponse.success(); 
		}catch(Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(@RequestBody Permission permission) {
		try {
			permissionService.edit(permission);
			return BaseResponse.success(); 
		}catch(Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
}
