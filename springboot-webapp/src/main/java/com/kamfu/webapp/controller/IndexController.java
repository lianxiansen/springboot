package com.kamfu.webapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.User;


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
    	User user =getUser();
        return "index";
    }
}
