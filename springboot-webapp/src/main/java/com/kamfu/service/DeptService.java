package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kamfu.entity.Dept;
import com.kamfu.mapper.DeptMapper;
import com.kamfu.model.LayuiTreeNode;

/**
 * 后台用户管理
 */

@Service
public class DeptService {

    @Resource
    private DeptMapper deptMapper;


    public List<Dept> selectList(Long deptId) {
    	return deptMapper.selectList(deptId);
    }
    public void add(Dept dept) throws Exception {
    	if(null!=dept.getPid()&&dept.getPid()>0) {
    		Dept parentDept=deptMapper.selectById(dept.getPid());
    		if(null!=parentDept) {
    			dept.setPids(parentDept.getPids()+"["+dept.getPid()+"]");
    			deptMapper.insert(dept);
    		}else {
    			throw new Exception("上级部门不存在");
    		}
    	}else {
    		throw new Exception("请选择上级部门");
    	}
    	
    }
}
