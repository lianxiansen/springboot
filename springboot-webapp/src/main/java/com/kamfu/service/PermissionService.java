package com.kamfu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.mapper.PermissionMapper;



@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


}
