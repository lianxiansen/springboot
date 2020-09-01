package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamfu.service.WebApiService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	WebApiService webApiService;
	@GetMapping("/getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request,String username){
		return webApiService.getUser(username);
//    	return AjaxResponse.success("成功",getUser());
    }
}
