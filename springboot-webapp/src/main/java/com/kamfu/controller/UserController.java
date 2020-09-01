package com.kamfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.model.AjaxResponse;
import com.kamfu.service.WebApiService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user")
public class UserController extends BaseController{
	private String PREFIX = "user/";
	

	@Autowired
	private WebApiService webApiService;
    @RequestMapping(value = "/list")
    @ResponseBody
    public AjaxResponse list(Long deptId,int page) {
    	return AjaxResponse.success("成功",webApiService.selectUserPagedList(deptId, page, page));
    }
}
