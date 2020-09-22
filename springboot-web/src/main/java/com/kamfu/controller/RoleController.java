package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Role;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.mapper.RolePermissionMapper;
import com.kamfu.model.BaseResponse;
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
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

	@GetMapping("/selectPagedList")
    @ResponseBody
    public PagedList<Role> selectPagedList(int page,int pagesize){
    	return roleService.selectPagedList(page, pagesize);
    }
	
	@GetMapping("/selectList")
    @ResponseBody
    public List<Role> selectList(){
    	return roleService.selectList();
    }
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(@RequestBody Role role) {
		int i=roleMapper.insert(role);
		if(i>0) {
			return BaseResponse.success();
		}
		else {
			return BaseResponse.fail();
		}
	}

	@RequestMapping(value="/addPermissions",method = RequestMethod.POST)
    @ResponseBody
	public BaseResponse addPermissions(Long roleId,String permissionIds){
		try {
			roleService.addPermissions(roleId, permissionIds);
			return BaseResponse.success();
		}catch(Exception e) {
			log.error(e.getMessage());
			return BaseResponse.fail();
		}
	}

}
