	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.User;
import com.kamfu.mapper.UserMapper;
import com.kamfu.model.UserParam;


/**
 * 后台用户管理
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过名称查找用户
     * @param username
     * @return
     */
    public User getByUsername(String username) {
    	return userMapper.getByUsername(username);
    }
    
    
    public List<User> selectPagedList(Long deptId,int pageIndex,int pageSize) {
    	UserParam param=new UserParam().setDeptId(deptId)
    			.setStart((pageIndex-1)*pageSize)
    			.setEnd(pageIndex*pageSize);
    	return userMapper.selectPagedList(param);
    }
}
