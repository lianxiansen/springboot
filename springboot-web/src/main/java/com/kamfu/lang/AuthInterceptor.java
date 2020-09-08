package com.kamfu.lang;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kamfu.config.SysConfig;
import com.kamfu.model.BaseResponse;
import com.kamfu.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    private SysConfig sysConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private  RedisTemplate<String,  String>  redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("前置拦截器****");
        String url= request.getRequestURL().toString();
        String token=request.getParameter("token");
        return true;	
//        if(null!=token) {
//        	String userJson=redisTemplate.opsForValue().get(token);
//        	User user=JSON.parseObject(userJson,User.class);
//            //返回true表示通过请求，返回false表示请求被拦截
//        	if(null!=user) {
//        		return true;	
//        	}
//        }
//        response.getWriter().write(BaseResponse.fail("no auth").toJSONString());
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("后置拦截器****");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("拦截器执行完成****");
    }
}