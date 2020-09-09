package com.kamfu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamfu.entity.Dept;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.factory.LayuiTreeBuildFactory;
import com.kamfu.mapper.DeptMapper;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.LayuiTreeNode;
import com.kamfu.service.DeptService;

import lombok.extern.log4j.Log4j2;
@RequestMapping("/dept")
@Controller
@Log4j2
public class DeptController extends AuthController{
	@Autowired
	private DeptService deptService;
	@Autowired
    private DeptMapper deptMapper;
	
	/**
	 * @Title: layuiTree
	 * @Description: 部门树形列表
	 * @param @param deptId
	 * @param @return 参数
	 * @return List<LayuiTreeNode> 返回类型
	 * @throws
	 */
	    
	@GetMapping("/layuiTree")
    @ResponseBody
    public List<LayuiTreeNode> layuiTree(Long deptId){
		
		
		List<LayuiTreeNode> list = deptService.layuiTree(deptId);
		LayuiTreeBuildFactory<LayuiTreeNode> treeBuildFactory = new LayuiTreeBuildFactory<>();
		return treeBuildFactory.doTreeBuild(list);
    }
	
	
	@GetMapping("/selectList")
    @ResponseBody
    public BaseResponse selectList(Long deptId){
		List<Dept> list= deptService.selectList(deptId);
		return BaseResponse.success("查询成功", list);
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(@RequestBody Dept dept) {
		try {
			deptService.add(dept);
			return BaseResponse.success(); 
		}catch(Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
}
