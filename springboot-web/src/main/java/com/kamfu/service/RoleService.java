package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.kamfu.entity.Role;
import com.kamfu.entity.RolePermissionTR;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.mapper.RolePermissionMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.RoleParam;
import com.kamfu.util.StringUtil;



@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    public PagedList<Role> selectPagedList(int page,int pagesize) {
    	RoleParam param=new RoleParam()
    			.setStart((page-1)*pagesize)
    			.setEnd(page*pagesize);
    	List<Role> list= roleMapper.selectPagedList(param);
    	
    	int count=roleMapper.selectCount(param);
    	PagedList<Role> pagedList=new PagedList<Role>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    @Transactional
    public void addPermissions(Long roleId,String permissionIds) {
    	rolePermissionMapper.delete(new EntityWrapper<RolePermissionTR>().eq("role_id", roleId));
    	if(StringUtil.isNotEmpty(permissionIds)) {
        	String[] list=permissionIds.split(",");
        	for(String permissionId :list) {
        		RolePermissionTR entity=new RolePermissionTR();
        		entity.setPermissionId(Long.valueOf(permissionId));
        		entity.setRoleId(roleId);
        		rolePermissionMapper.insert(entity);
        	}
    	}

    }
}
