package com.kamfu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Permission;
import com.kamfu.entity.RolePermissionTR;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RolePermissionMapper;
import com.kamfu.model.PermissionInfo;



@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    public List<Permission> selectList() {
    
    	return permissionMapper.selectList();
    }
    
    public List<PermissionInfo> selectAllListByRoleId(Long roleId){
    	List<PermissionInfo> result=new ArrayList<PermissionInfo>();
    	List<Permission> permissionList=permissionMapper.selectList();
    	List<RolePermissionTR> rolePermissionList=rolePermissionMapper.selectList(roleId);
    	for(Permission permission :permissionList) {
    		
    		boolean checked=false;
    		for(RolePermissionTR rolePermissionTR :rolePermissionList) {
    			if(permission.getId().equals(rolePermissionTR.getPermissionId())) {
    				checked=true;
    				break;
    			}
    		}
    		PermissionInfo info=new PermissionInfo().setChecked(checked)
    				.setId(permission.getId())
    				.setName(permission.getName())
    				.setOpen(true)
    				.setPId(permission.getPid());
    		result.add(info);
    	}
    	return result;
    }
}
