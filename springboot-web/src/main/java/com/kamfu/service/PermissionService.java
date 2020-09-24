package com.kamfu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.RolePermissionTR;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.mapper.RolePermissionMapper;
import com.kamfu.model.PermissionInfo;



@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    public List<Permission> selectList() {
    
    	return permissionMapper.selectList();
    }
    
    
    /**
     * @Title: selectTreeListByRoleId
     * @Description: 查看自己权限范围内选中的角色的权限
     * @param @param roleIdChoose
     * @param @param roleIdMe
     * @param @return 参数
     * @return List<PermissionInfo> 返回类型
     * @throws
     */
        
    public List<PermissionInfo> selectTreeListByRoleId(Long roleIdChoose,Long roleIdMe){
    	List<PermissionInfo> result=new ArrayList<PermissionInfo>();
    	List<RolePermissionTR> rolePermissionMeList=rolePermissionMapper.selectList(roleIdMe);
    	
    	List<RolePermissionTR> rolePermissionChooseList=rolePermissionMapper.selectList(roleIdChoose);
    	for(RolePermissionTR parentRolePermissionTR :rolePermissionMeList) {
    		Permission permission=permissionMapper.selectById(parentRolePermissionTR.getPermissionId());
    		if(null!=permission) {
        		boolean checked=false;
        		for(RolePermissionTR rolePermissionTR :rolePermissionChooseList) {
        			if(parentRolePermissionTR.getPermissionId().equals(rolePermissionTR.getPermissionId())) {
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

    	}
    	
    	

    	return result;
    }
}
