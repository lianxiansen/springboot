package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping("/getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request,String username){
    	return "getUser";
    }
}
