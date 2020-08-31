package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

    /**
     * 通过名称查找用户
     * @param username
     * @return
     */
    public List<Dept> likePids(Long deptId) {
    	return deptMapper.likePids(deptId);
    }
    public List<LayuiTreeNode> layuiTree(Long deptId){
    	return deptMapper.layuiTree(deptId);
    }
}
