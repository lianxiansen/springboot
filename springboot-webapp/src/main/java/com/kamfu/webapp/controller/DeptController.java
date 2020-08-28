package com.kamfu.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.model.LayuiTreeNode;
import com.kamfu.service.DeptService;
import com.kamfu.webapp.factory.LayuiTreeBuildFactory;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/dept")
public class DeptController extends BaseController{
	private String PREFIX = "system/";
	@Autowired
	private DeptService deptService;
    @RequestMapping("index")
    public String index() {
        return PREFIX + "dept.html";
    }
    
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }
    
    
    @RequestMapping(value = "/layuiTree")
    @ResponseBody
    public List<LayuiTreeNode> layuiTree() {

        List<LayuiTreeNode> list = deptService.layuiTree(getUser().getDeptId());
//        list.add(LayuiTreeFactory.createRoot());
        LayuiTreeBuildFactory<LayuiTreeNode> treeBuildFactory = new LayuiTreeBuildFactory<>();
//        treeBuildFactory.setRootParentId("-1");
        return treeBuildFactory.doTreeBuild(list);
    }
}
