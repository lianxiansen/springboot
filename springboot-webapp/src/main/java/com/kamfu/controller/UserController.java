package com.kamfu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.PagedList;
import com.kamfu.model.PagedResponse;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
public class UserController extends BaseController{
	private String PREFIX = "system/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "user.html";
    }

    @RequestMapping(value = "/pagedList")
    @ResponseBody
    public BaseResponse pagedList(Long deptId,int page,int limit) {
    	if(null==deptId) {
    		deptId=getUser().getDeptId();
    	}
    	 PagedList<User> pagedList=userService.selectPagedList(deptId, page, limit);
    	 return PagedResponse.success("成功",pagedList.getData(),pagedList.getCount());
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(User user) {
    	user.setCreateTime(new Date());
    	user.setCreateUser(getUser().getUserId());
    	user.setUpdateTime(new Date());
    	user.setUpdateUser(getUser().getUserId());
		try {
			userService.add(user);
			return BaseResponse.success(); 
		}catch(Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
    }
}
