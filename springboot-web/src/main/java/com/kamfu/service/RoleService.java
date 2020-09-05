package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Role;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.RoleParam;



@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    public List<Role> selectPagedList(int pageIndex,int pageSize) {
    	RoleParam param=new RoleParam()
    			.setStart((pageIndex-1)*pageSize)
    			.setEnd(pageIndex*pageSize);
    	return roleMapper.selectPagedList(param);
    }
}
