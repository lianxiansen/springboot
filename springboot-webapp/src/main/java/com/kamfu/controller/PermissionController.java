package com.kamfu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedResponse;
import com.kamfu.service.WebApiService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/permission")
public class PermissionController extends BaseController{
	private String PREFIX = "system/";
	@Autowired
	private WebApiService webApiService;

    @RequestMapping("index")
    public String index() {
        return PREFIX + "permission.html";
    }

    
    @RequestMapping(value = "/list")
    @ResponseBody
    public BaseResponse list() {
    	 return BaseResponse.success("成功",webApiService.selectPermissionList());
    }
    
    @RequestMapping(value = "/selectTreeListByRoleId")
    @ResponseBody
    public BaseResponse selectTreeListByRoleId(Long roleId) {
    	 return BaseResponse.success("成功",webApiService.selectPermissionTreeListByRoleId(roleId,getUser().getRole().getId()));
    }
    
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(Permission permission) {
    	permission.setCreateTime(new Date());
    	permission.setCreateUser(getUser().getUserId());
    	permission.setUpdateTime(new Date());
    	permission.setUpdateUser(getUser().getUserId());
    	BaseResponse baseResponse= webApiService.addPermission(permission);
    	return baseResponse;
    }
    
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse edit(Permission permission) {
    	permission.setUpdateTime(new Date());
    	permission.setUpdateUser(getUser().getUserId());
    	BaseResponse baseResponse= webApiService.editPermission(permission);
    	return baseResponse;
    }
}
