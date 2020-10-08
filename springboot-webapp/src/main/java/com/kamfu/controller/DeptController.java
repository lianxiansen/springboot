package com.kamfu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Dept;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.LayuiTreeNode;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/dept")
public class DeptController extends BaseController{
	private String PREFIX = "system/";
    @RequestMapping("index")
    public String index() {
        return PREFIX + "dept.html";
    }
    
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }
    
    
//    @RequestMapping(value = "/layuiTree")
//    @ResponseBody
//    public List<LayuiTreeNode> layuiTree() {
//
//    	return webApiService.layuiTree(getUser().getDeptId());
//    }
    
    @RequestMapping(value = "/selectList")
    @ResponseBody
    public BaseResponse selectList() {
		List<Dept> list= deptService.selectList(getUser().getDeptId());
		return BaseResponse.success("查询成功", list);
    }
    
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResponse add(Dept dept) {
    	dept.setCreateTime(new Date());
    	dept.setCreateUser(getUser().getUserId());
    	dept.setUpdateTime(new Date());
    	dept.setUpdateUser(getUser().getUserId());
		try {
			deptService.add(dept);
			return BaseResponse.success(); 
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
		
    }
}
