package com.kamfu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.mybatis.mapper.RoleMapper;



@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;


}
