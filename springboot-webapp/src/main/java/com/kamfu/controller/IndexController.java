package com.kamfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kamfu.model.dto.UserInfo;

import lombok.extern.log4j.Log4j2;

/**
 * Description: 登录验证
 */

// 只用同时具有permission:view和permission:aix权限才能访问
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.AND)
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.OR)一个就行

@Controller
@Log4j2
public class IndexController extends BaseController{
	@RequestMapping({"/index", "/"})
    public String index() {
		//获取当前登入的用户信息
		UserInfo user =getUser();
        return "index";
    }
	
	@RequestMapping({"/home"})
    public String home() {
        return "home";
    }
}
