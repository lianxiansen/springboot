package com.kamfu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.model.BaseResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/permission")
public class PermissionController extends BaseController{
	private String PREFIX = "system/";

    @RequestMapping("index")
    public String index() {
        return PREFIX + "permission.html";
    }

    
    @RequestMapping(value = "/list")
    @ResponseBody
    public BaseResponse list() {
    	
    	 return BaseResponse.success("成功",permissionService.selectList());
    }
    
    @RequestMapping(value = "/selectTreeListByRoleId")
    @ResponseBody
    public BaseResponse selectTreeListByRoleId(Long roleId) {
    	 return BaseResponse.success("成功",permissionService.selectTreeListByRoleId(roleId,getUser().getRole().getId()));
    }
    
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(Permission permission) {
    	permission.setCreateTime(new Date());
    	permission.setCreateUser(getUser().getUserId());
    	permission.setUpdateTime(new Date());
    	permission.setUpdateUser(getUser().getUserId());
		try {
			permissionService.add(permission);
			return BaseResponse.success(); 
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
    }
    
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse edit(Permission permission) {
    	permission.setUpdateTime(new Date());
    	permission.setUpdateUser(getUser().getUserId());
    	try {
			permissionService.edit(permission);
			return BaseResponse.success(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return BaseResponse.fail(e.getMessage());
		}
    }
}
