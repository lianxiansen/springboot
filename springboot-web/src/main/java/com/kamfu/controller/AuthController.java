package com.kamfu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.kamfu.entity.User;
import com.kamfu.service.UserService;
import com.kamfu.util.JwtUtil;

public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;
	@Autowired
	private HttpServletRequest request;
	public User getUser() {
        String token = request.getHeader("token");
        String userJson= redisTemplate.opsForValue().get(token);
        User user=JSONObject.parseObject(userJson,User.class);
        if(null!=user) {
            boolean verity = JwtUtil.verity(token);
            if (verity) {
            	return user;
            }
        }

        return null;
	}
}
