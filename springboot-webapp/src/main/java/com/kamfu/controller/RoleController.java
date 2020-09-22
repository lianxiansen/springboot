package com.kamfu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Role;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;
import com.kamfu.service.WebApiService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/role")
public class RoleController extends BaseController{
	private String PREFIX = "system/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "role.html";
    }
	
	@Autowired
	private WebApiService webApiService;
    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse list(int page,int limit) {
    	 PagedList<Role> pagedList=webApiService.selectRolePagedList(page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
    @RequestMapping(value = "/list")
    @ResponseBody
    public BaseResponse list() {
    	 List<Role> list=webApiService.selectRoleList();
    	 return BaseResponse.success("成功",list);
    }
    
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResponse add(Role role) {
    	role.setCreateTime(new Date());
    	role.setCreateUser(getUser().getUserId());
    	role.setUpdateTime(new Date());
    	role.setUpdateUser(getUser().getUserId());
    	return webApiService.addRole(role);
    }
    @RequestMapping(value = "/addPermissions")
    @ResponseBody
    public BaseResponse addPermissions(Long roleId,String permissionIds) {

    	return webApiService.addPermissions(roleId, permissionIds);
    }
}
