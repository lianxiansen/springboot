package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.PermissionParam;
import com.kamfu.model.RoleParam;



@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    public List<Permission> selectPagedList(int pageIndex,int pageSize) {
    	PermissionParam param=new PermissionParam()
    			.setStart((pageIndex-1)*pageSize)
    			.setEnd(pageIndex*pageSize);
    	return permissionMapper.selectPagedList(param);
    }
}
