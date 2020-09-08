package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.RoleParam;



@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

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
}
