package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Dept;
import com.kamfu.model.LayuiTreeNode;


/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {


    List<Dept> selectList(@Param("deptId") Long deptId);
    List<Long> selectIdList(@Param("deptId") Long deptId);
	List<LayuiTreeNode> layuiTree(@Param("deptId") Long deptId);

}
