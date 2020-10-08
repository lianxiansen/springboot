package com.kamfu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.service.UserService;

@RestController
@RequestMapping(headers = "version=1")
public class TestControllerV1 {
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
    @ResponseBody
    public BaseResponse getUserInfo(HttpServletRequest request,String username){
    	return BaseResponse.success("成功","version1");
    }
    
}
