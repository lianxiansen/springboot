package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Dept;
import com.kamfu.model.LayuiTreeNode;
import com.kamfu.mybatis.DSEnum;
import com.kamfu.mybatis.DataSource;
import com.kamfu.mybatis.mapper.DeptMapper;

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
    @DataSource(name = DSEnum.DATA_SOURCE_CORE)
    public List<Dept> likePids(Long deptId) {
    	return deptMapper.likePids(deptId);
    }
    @DataSource(name = DSEnum.DATA_SOURCE_CORE)
    public List<LayuiTreeNode> layuiTree(Long deptId){
    	return deptMapper.layuiTree(deptId);
    }
}
