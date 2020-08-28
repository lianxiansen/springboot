package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.User;
import com.kamfu.mybatis.DSEnum;
import com.kamfu.mybatis.DataSource;
import com.kamfu.mybatis.mapper.UserMapper;


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
    @DataSource(name = DSEnum.DATA_SOURCE_CORE)
    public User getByUsername(String username) {
    	return userMapper.getByUsername(username);
    }
    
    
    @DataSource(name = DSEnum.DATA_SOURCE_CORE)
    public List<User> selectPagedList(Long deptId,int pageIndex) {
    	return userMapper.selectPagedList(deptId,pageIndex);
    }
}
