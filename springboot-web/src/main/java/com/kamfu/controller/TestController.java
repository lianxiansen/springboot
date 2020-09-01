package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Value("${config.producer.instance:0}")
	private int instance;
	@GetMapping("/getUser")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request,String username){
    	return "[instance：" + instance + "]"+AjaxResponse.success("成功",getUser(username)).toJSONString();
    }
    private User getUser(String username) {
    	return userService.getByUsername(username);
    }
}
