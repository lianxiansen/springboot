	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.User;
import com.kamfu.mapper.UserMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.UserParam;
import com.kamfu.util.Md5Util;
import com.kamfu.util.StringUtil;


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
    
    
    public PagedList<User> selectPagedList(Long deptId,int page,int pagesize) {
    	UserParam param=new UserParam().setDeptId(deptId)
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<User> list= userMapper.selectPagedList(param);
    	int count=userMapper.selectCount(param);
    	PagedList<User> pagedList=new PagedList<User>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
    public void add(User user) {
    	if(StringUtil.isNotEmpty(user.getPassword())) {
    		  String salt = Md5Util.getRandomSalt();
    		  String encryptionPassword=Md5Util.encrypt(user.getPassword(), salt);
    		  user.setSalt(salt);
    		  user.setPassword(encryptionPassword);
    		  userMapper.insert(user);
    	}
    }
}
