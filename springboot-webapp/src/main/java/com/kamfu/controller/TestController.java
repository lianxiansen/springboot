package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamfu.entity.User;
import com.kamfu.remote.UserRemote;
import com.kamfu.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRemote userRemote;
	@GetMapping("/getUser")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request,String username){
		return userRemote.getUser(username);
//    	return AjaxResponse.success("成功",getUser());
    }
    private User getUser() {
    	return userService.getByUsername("admin");
    }
}
