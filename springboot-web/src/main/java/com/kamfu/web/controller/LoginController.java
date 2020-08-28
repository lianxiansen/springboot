package com.kamfu.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kamfu.entity.User;
import com.kamfu.model.AjaxResponse;
import com.kamfu.service.UserService;
import com.kamfu.util.JwtUtil;
import com.kamfu.web.config.SysConfig;

import lombok.extern.log4j.Log4j2;

/**
 * Description: 登录验证
 */

// 只用同时具有permission:view和permission:aix权限才能访问
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.AND)
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.OR)一个就行

@Controller
@Log4j2
public class LoginController extends AuthController{

    @Resource
    private SysConfig sysConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private  RedisTemplate<String,  String>  redisTemplate;
    /**
     * POST登录
     * @param map
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody Map<String,String> map) {
    	String username = map.get("username");
        String passWord = map.get("passWord");
        log.info("*****************************");
        //身份验证
        User user = userService.getByUsername(username);
        if (user != null) {
            //返回token
           String token = JwtUtil.sign(username, passWord);
            if (token != null) {
            	redisTemplate.opsForValue().set(token, JSON.toJSONString(user));
                return AjaxResponse.success("成功",token).toJSONString();
            }
        }
        return AjaxResponse.fail().toJSONString();
    }
    @PostMapping("getUser")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request){
    	return AjaxResponse.success("成功",getUser()).toJSONString();
    }
}
