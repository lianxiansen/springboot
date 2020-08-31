package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamfu.entity.User;
import com.kamfu.model.AjaxResponse;
import com.kamfu.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
    @PostMapping("getUser")
    @ResponseBody
    public AjaxResponse getUserInfo(HttpServletRequest request){
    	return AjaxResponse.success("成功",getUser());
    }
    private User getUser() {
    	return userService.getByUsername("admin");
    }
}
