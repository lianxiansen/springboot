package com.kamfu.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.User;
import com.kamfu.model.AjaxResponse;
import com.kamfu.service.UserService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
public class UserController extends BaseController{
	private String PREFIX = "user/";
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/list")
    @ResponseBody
    public AjaxResponse list(Long deptId,int page) {
    	List<User> list=userService.selectPagedList(deptId, page,pageSize);
    	return AjaxResponse.success("成功",list);
    }
}
