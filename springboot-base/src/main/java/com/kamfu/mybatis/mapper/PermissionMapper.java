package com.kamfu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Permission;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
	List<Permission> selectListByRoleId(Long roleId);
}
