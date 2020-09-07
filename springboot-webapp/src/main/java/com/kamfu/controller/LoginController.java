package com.kamfu.controller;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;

import lombok.extern.log4j.Log4j2;

/**
 * Description: 登录验证
 */

// 只用同时具有permission:view和permission:aix权限才能访问
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.AND)
//@RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.OR)一个就行

@Controller
@Log4j2
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    /**
     * POST登录
     * @param map
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password) {
//    	String username = map.get("username");
//        String password = map.get("password");
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
     // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
        	return BaseResponse.fail("未知账户").toJSONString();
        } catch (IncorrectCredentialsException ice) {
            return BaseResponse.fail("密码不正确").toJSONString();
        } catch (LockedAccountException lae) {
            return BaseResponse.fail("账户已锁定").toJSONString();
        } catch (ExcessiveAttemptsException eae) {
            return BaseResponse.fail("用户名或密码错误次数过多").toJSONString();
        } catch (AuthenticationException ae) {
            return BaseResponse.fail("用户名或密码不正确！").toJSONString();
        }
        if (subject.isAuthenticated()) {
        	return BaseResponse.success().toJSONString();
        } else {
            token.clear();
            return BaseResponse.fail().toJSONString();
        }
    }
    
    
    public String logout() {
    	return null;
    }
}
