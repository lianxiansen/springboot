package com.kamfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Permission;
import com.kamfu.service.PermissionService;

import lombok.extern.log4j.Log4j2;
@RequestMapping("/permission")
@Controller
@Log4j2
public class PermissionController extends AuthController{

    @Autowired
    private PermissionService permissionService;


	@GetMapping("/selectPagedList")
    @ResponseBody
    public List<Permission> selectPagedList(int page,int pagesize){
    	return permissionService.selectPagedList(page, pagesize);
    }

}
